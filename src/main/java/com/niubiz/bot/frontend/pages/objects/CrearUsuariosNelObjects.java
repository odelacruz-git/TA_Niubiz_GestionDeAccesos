package com.niubiz.bot.frontend.pages.objects;

import org.openqa.selenium.By;

public class CrearUsuariosNelObjects {
    public By TXT_TITULO_CREAR_USUARIO = By.xpath("//span[contains(.,'CREAR USUARIO')]");
    public By BTN_COMERCIO_BACK_CREAR_USUARIO = By.xpath("//div[contains(@class,'icon-back-copy')]");
    public By BTN_NIUBIZ_BACK_CREAR_USUARIO = By.xpath("//div[contains(@class,'icon icon-back-copy return')]");
    public By BTN_INFORMACION_USUARIO = By.xpath("//div[@role='button'][contains(.,'INFORMACIÓN DEL USUARIO')]");
    public By BTN_RUCS_CODIGOS = By.xpath("//div[@role='button'][contains(.,'RUCS Y CÓDIGOS')]");
    public By BTN_MODULOS = By.xpath("//div[@role='button'][contains(.,'MÓDULOS')]");
    public By BTN_ASIGNACION_PERFIL = By.xpath("//div[@role='button'][contains(.,'ASIGNACIÓN DE PERFIL')]");
    public By FORM_ACORDEON_INFO_USUARIOS = By.xpath("(//div[@class='el-collapse-item__wrap'])[1]");
    public By ACORDEON_INFO_USUARIO = By.xpath("//div[@role='button'][contains(.,'INFORMACIÓN DEL USUARIO')]");
    public By FORM_ACORDEON_RUCS_CODIGOS = By.xpath("(//div[@class='el-collapse-item__wrap'])[2]");
    public By FORM_ACORDEON_MODULOS = By.xpath("(//div[@class='el-collapse-item__wrap'])[3]");
    public By FORM_ACORDEON_ASIGNACION_PERFIL = By.xpath("(//div[@class='el-collapse-item__wrap'])[2]");
    public By TXTBOX_CORREO_USUARIO = By.xpath("//input[contains(@maxlength,'60')]");
    public By TXTBOX_CORREO_ELECTRONICO = By.xpath("(//label[text()='Correo electrónico']/following::input)[1]");
    public By TXTBOX_NOMBRES = By.xpath("(//label[text()='Nombres']/following::input)[1]");
    public By TXTBOX_APELLIDO_PATERNO = By.xpath("(//label[text()='Apellido Paterno']/following::input)[1]");
    public By TXTBOX_APELLIDO_MATERNO = By.xpath("(//label[text()='Apellido Materno']/following::input)[1]");
    public By LISTBOX_TIPO_DOC = By.xpath("(//label[text()='Tipo de Documento']/following::input)[1]");
    public By LISTBOX_AREA = By.xpath("(//label[text()='Área']/following::input)[1]");
    public By OPTION_LIST_AREA = By.xpath("//span[text()='CAPITAL HUMANO']");
    public By TXTBOX_DOCUMENTO = By.xpath("(//label[text()='Número de documento']/following::input)[1]");
    public By BTN_SIGUIENTE_INFO_USUARIOS = By.xpath("//button[@type='button'][contains(.,'Siguiente')][1]");
    public By BTN_SIGUIENTE_RUCS_CODIGOS = By.xpath("(//button[contains(@class,'el-button button-user')])[2]");
    public By SUBTITULO_RUCS_CODIGOS = By.xpath("//p[@class='subtitle'][contains(.,'Selecciona el RUC y códigos a los cuales quieres que tenga acceso el usuario.')]");
    public By BTN_SIGUIENTE_MODULOS = By.xpath("(//button[@class='el-button el-button--default']/following-sibling::button)[1]");
    public By OPTION_DNI = By.xpath("//li[@class='el-select-dropdown__item'][contains(.,'DNI')]");
    public By CHECKBOX_RUCS_CODIGOS (String ruc) {
        return By.xpath("//label[@for='chk_"+ ruc + "']");
    }
    public By LISTA_RUCS_CODIGOS = By.xpath("(//div[@class='scrollbar']//ul)[1]");
    public By BTN_TODOS = By.xpath("(//li[text()='Todos'])");
    public By BTN_TODOS_POR_RUC (String ruc) {return By.xpath("//li[contains(@id,'"+ruc+"')][contains(.,'Todos')][@class='enabled-li active']");}
    public By BTN_SELECCIONAR = By.xpath("(//li[text()='Seleccionar'])");
    public By BTN_SELECCIONAR_POR_RUC (String ruc) {return By.xpath("//li[contains(@id,'"+ruc+"')][contains(.,'Seleccionar')][@class='enabled-li']");}
    public By BTN_GUARDAR_DISABLED = By.xpath("//button[@disabled='disabled'][contains(.,'Guardar')]");
    public By BTN_GUARDAR_DISABLED_NBZ = By.xpath("//button[@disabled='disabled'][contains(.,'GUARDAR')]");
    public  By BTN_CANCELAR = By.xpath("//button[@type='button'][contains(.,'Cancelar')]");
    public  By BTN_CANCELAR_NBZ = By.xpath("//button[@type='button'][contains(.,'CANCELAR')]");
    public  By BTN_HACIA_ATRAS = By.className("icon-back-copy");
    public By BTN_AGREGAR_AREA = By.xpath("//button[contains(@class,'el-button el-button--success is-circle')]");
    public By TXT_PF_LLENAR_CAMPOS = By.xpath("//span[text()='Por favor llena todos los campos de esta sección']");
    public By TXT_CAMPO_OBLIGATORIO (String num) {
        return By.xpath("(//div[@class='el-form-item__error'][contains(.,'Campo obligatorio')])["+num+"]");
    }
    public By INFO_CORREO_VALIDO = By.xpath("//div[text()[normalize-space()='Ingrese un correo válido']]");
    public By INFO_TEXTO_NO_VALIDO = By.xpath("//div[@class='el-form-item__error'][contains(.,'Texto no válido')]");

    public By INFO_MARCA_UN_RUC = By.xpath("//span[@class='ml-2 el-form-item__error'][contains(.,'* Debes marcar por lo menos 1 RUC')]");

    public By TXT_BUSQUEDA_POR_CODIGO = By.xpath("//div[@class='sub-title'][contains(.,'Búsqueda por código')]");
    public By TXT_SELECCIONE_CODIGOS = By.xpath("//div[@class='modal-access-title'][contains(.,'Seleccione los código a los que se dará acceso')]");
    public By RESULTADO_LISTA_CODIGOS (String codigo) {
        return By.xpath("//div[@class='list-commerces'][contains(.,'"+codigo+"')]");
    }
    public By OPCION_LISTA_CODIGOS (String codigo) {
        return By.xpath("//div[@class='value'][contains(.,'"+codigo+" -')]");
    }
    public By INPUT_BUSQUEDA_CODIGO = By.xpath("//input[@placeholder='Ingrese el código']");
    public By ROW_TABLA_CODIGO_SELECCIONADO (String codigo) {
        return By.xpath("//tr[@class='el-table__row'][contains(.,'"+codigo+"')]");
    }
    public By CHECKBOX_SELECCIONAR_TODOS = By.xpath("//span[text()='Seleccionar todos']");
    public By REGISTROS_CODIGOS_SELECCIONADOS = By.xpath("(//tr[@class='el-table__row'])");
    public By BTN_ACEPTAR_DISABLED = By.xpath("//button[contains(@class,'el-button ml-5 el-button--primary is-disabled')]");
    public By BTN_ACEPTAR_ENABLE = By.xpath("//button[contains(@class,'el-button ml-5')]");
    public By TXT_CODIGOS_SELECCIONADOS (String ruc) {
        return By.xpath("//div[@class='business'][contains(.,'"+ruc+" - RIMAC SEGUROS Y REASEGUROSTodosSeleccionar1/451 seleccionados')]");
    }
    public By BTN_SELECCIONAR_ENABLE (String ruc) {
        return By.xpath("//li[contains(@id,'btnSelector_"+ruc+"')][contains(.,'Seleccionar')]");
    }
    public By TOOLTIP_MODULOS_PAGINA_INICIO = By.xpath("//div[@role='tooltip'][contains(.,'Todos los usuarios tienen acceso a la pantalla de inicio')]");
    public By INFO_MODULOS_MIS_VENTAS = By.xpath("(//i[contains(@class,'el-tooltip info')])[1]");
    public By TOOLTIP_INFO_MODULOS_MIS_VENTAS = By.xpath("//div[@role='tooltip'][contains(.,'Accesso a la información de las ventas de los últimos 12 meses')]");
    public By INFO_MODULOS_MIS_DEPOSITOS = By.xpath("(//i[contains(@class,'el-tooltip info')])[2]");
    public By TOOLTIP_INFO_MODULOS_MIS_DEPOSITOS = By.xpath("//div[@role='tooltip'][contains(.,'Accesso a la información de tus depósitos de los últimos 12 meses')]");
    public By INFO_MODULOS_MIS_CANJES = By.xpath("(//i[contains(@class,'el-tooltip info')])[3]");
    public By TOOLTIP_INFO_MODULOS_MIS_CANJES = By.xpath("//div[@role='tooltip'][contains(.,'Acceso a la información los canjes realizados en los últimos 12 meses')]");
    public By INFO_MODULOS_COMPROBANTE_PAGO= By.xpath("(//i[contains(@class,'el-tooltip info')])[4]");
    public By TOOLTIP_INFO_COMPROBANTE_PAGO = By.xpath("//div[@role='tooltip'][contains(.,'El documento autorizado se genera para todos los códigos asociados al RUC.')]");
    public By INFO_MODULOS_ADMINISTRAR_USUARIOS = By.xpath("(//i[contains(@class,'el-tooltip info')])[5]");
    public By TOOLTIP_INFO_ADMINISTRAR_USUARIOS = By.xpath("//div[@role='tooltip'][contains(.,'Acceso a crear, editar, inactivar, activar y generar reporte de usuarios')]");
    public By CHECKBOX_MODULOS_PAGINA_INICIO = By.xpath("(//input[@class='el-checkbox__original'])[1]");
    public By CHECKBOX_MODULOS_MIS_VENTAS = By.xpath("(//input[@class='el-checkbox__original'])[2]");
    public By CHECKBOX_MODULOS_MIS_DEPOSITOS = By.xpath("(//input[@class='el-checkbox__original'])[3]");
    public By CHECKBOX_MODULOS_MIS_CANJES = By.xpath("(//input[@class='el-checkbox__original'])[4]");
    public By CHECKBOX_MODULOS_COMPROBANTE_PAGO = By.xpath("(//input[@class='el-checkbox__original'])[5]");
    public By CHECKBOX_MODULOS_REPORTE_DEVOLUCIONES = By.xpath("(//input[@class='el-checkbox__original'])[6]");
    public By CHECKBOX_MODULOS_REGISTRAR_DEVOLUCIONES = By.xpath("(//input[@class='el-checkbox__original'])[7]");
    public By CHECKBOX_MODULOS_REGISTRAR_CUENTA_BANCARIA = By.xpath("(//input[@class='el-checkbox__original'])[8]");
    public By CHECKBOX_MODULOS_ADMINISTRAR_USUARIOS = By.xpath("(//input[@class='el-checkbox__original'])[9]");
    public By TEXT_PREGUNTA_REGISTRO_DEVOLUCIONES = By.xpath("//span[@class='mr-4'][contains(.,'¿Desea establecer un monto máximo para las devoluciones registradas por este usuario?')]");
    public By RADIO_BUTTON_OPCIONES_REGISTRO_DEVOLUCIONES = By.xpath("//div[@role='radiogroup'][contains(.,'SíNo')]");
    public By OPCION_REGISTRAR_DEVOLUCIONES = By.xpath("//label[@class='el-checkbox'][contains(.,'Registrar devoluciones')]");
    public By RADIO_BUTTON_SI_REGISTRAR_DEVOLUCIONES = By.xpath("//label[@role='radio'][contains(.,'Sí')]");
    public By FORM_INGRESE_MONTO_DEVOLVER = By.xpath("//div[@class='amount-return'][contains(.,'* Ingrese monto máximo a devolver:S/Las devoluciones que excedan el monto máximo deberán ser aprobadas por otro usuario.')]");
    public By BOTON_SELECCIONAR_USUARIOS_APROBADORES = By.xpath("//button[@type='button'][contains(.,'Seleccionar usuarios aprobadores')]");
    public By INPUT_PLACEHOLDER_REGISTRAR_DEVOLUCIONES = By.xpath("//input[@placeholder='0']");
    public By INFO_INGRESE_MONTO_VALIDO = By.xpath("//span[text()='*Ingrese un monto válido.']");
    public By POPUP_USUARIOS_APROBADORES = By.xpath("(//div[@class='el-dialog'])[3]");
    public By TITULO_POPUP_USUARIOS_APROBADORES = By.xpath("//div[text()='Seleccione uno o más usuarios']");



}
