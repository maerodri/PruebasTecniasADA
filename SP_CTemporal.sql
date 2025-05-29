CREATE DEFINER=`root`@`localhost` PROCEDURE `CTemporal`()
BEGIN

DECLARE ID_TEMPORAL,id_com,ID_APP,ID_VERSION,ID_VERSION_COMPANY INTEGER;
DECLARE APP_CODIGO,APP_NOMBRE,APP_DESCRIPCION VARCHAR(100);
DECLARE code_company, n_company, des_company VARCHAR(45);
DECLARE V_VERSION,VERSION_DESCRIPCION VARCHAR(60);
DECLARE VERSION_COMPANY_DESCRIPCION VARCHAR(60);
DECLARE ID_APP_R,ID_VERSION_R,ID_COMPANY_R INTEGER;


DECLARE LONGITUD INT DEFAULT 0;

DECLARE CTemporal CURSOR FOR SELECT 
id_tmp, 
id_company, 
codigo_company, 
name_company, 
description_company, 
app_id, 
app_code, 
app_name, 
app_description,
version_id, 
version, 
version_description, 
app_id_r, 
version_company_id, 
version_company_description, 
company_id_r, 
version_id_r 
FROM tmp_llenar_campos WHERE state is false;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET LONGITUD = 1;

OPEN CTemporal;

bucle: LOOP FETCH CTemporal INTO 
ID_TEMPORAL, 
id_com, 
code_company, 
n_company, 
des_company, 
ID_APP,
APP_CODIGO,
APP_NOMBRE,
APP_DESCRIPCION,
ID_VERSION,
V_VERSION,
VERSION_DESCRIPCION,
ID_APP_R,
ID_VERSION_COMPANY,
VERSION_COMPANY_DESCRIPCION,
ID_COMPANY_R,
ID_VERSION_R;
    
    IF LONGITUD = 1 THEN
     LEAVE bucle;
     END IF;
     
     INSERT INTO company(id_company,codigo_company,name_company,description_company) VALUES(id_com, code_company, n_company, des_company);
     INSERT INTO application(app_id,app_code,app_name,app_description) VALUES(ID_APP,APP_CODIGO,APP_NOMBRE,APP_DESCRIPCION);
     INSERT INTO version(version_id,version,version_description,application_id) VALUES(ID_VERSION,V_VERSION,VERSION_DESCRIPCION,ID_APP_R);
     INSERT INTO version_company(version_company_id,version_company_description,company_id,version_id) VALUES (ID_VERSION_COMPANY,VERSION_COMPANY_DESCRIPCION,ID_COMPANY_R,ID_VERSION_R);
    
    
     UPDATE tmp_llenar_campos SET state = TRUE WHERE id_tmp = ID_TEMPORAL;
    
END LOOP bucle;
CLOSE CTemporal;


END