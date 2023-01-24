@F_CREAR_USUARIOS
Feature: FUNCIONALIDAD ADMINISTRAR USUARIOS
  Background:
 #   Given el usuario se encuentra logueado a la web de Nel con perfil <profile>

  @titulo_crear_usuario
  Scenario Outline: <N>_<CP>_validar que en la cabecera se muestre el titulo 'CREAR USUARIO'
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que se muestre el título 'CREAR USUARIO'
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 8     | CP008  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 122   | CP122  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 236   | CP236  |

  @btn_retorno
  Scenario Outline: <N>_<CP>_validar que en la cabecera se muestre boton de retorno al crear nuevo usuario
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que se muestre el boton de retorno
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 7     | CP007  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 121   | CP121  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 235   | CP235  |

  @btn_retorno
  Scenario Outline: <N>_<CP>_validar que en la cabecera se muestre boton de retorno al crear nuevo usuario
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que se muestre el boton de retorno
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 462   | CP462  |

  @txt_secciones_crear_usuario
  Scenario Outline: <N>_<CP>_validar que se visualicen las secciones del modulo crear usuario
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que se visualice las secciones INFORMACION DE USUARIO,RUCS&CODIGO y MODULOS
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 9     | CP009  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 123   | CP123  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 237   | CP237  |

  @acordeon_seccion_info_usuarios
  Scenario Outline: <N>_<CP>_validar el comportamiento del acordeon al seleccionar una seccion desplegable
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que se oculten los campos dentro de la sección desplegable
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 10    | CP010  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 124   | CP124  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 238   | CP238  |

  @acordeon_seccion_info_usuarios
  Scenario Outline: <N>_<CP>_validar el comportamiento del acordeon al seleccionar una seccion desplegable
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que se oculten los campos dentro de la sección desplegable
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 441   | CP441  |

  @boton_guardar
  Scenario Outline: <N>_<CP>_validar el estado del botón guardar al ingresar al modulo CREAR USUARIO por primera vez
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el botón GUARDAR se encuentre deshabilitado
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 11    | CP011  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 125   | CP125  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 239   | CP239  |

  @boton_guardar
  Scenario Outline: <N>_<CP>_validar el estado del botón guardar al ingresar al modulo CREAR USUARIO por primera vez
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el botón GUARDAR se encuentre deshabilitado
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 442   | CP442  |

  @boton_cancelar
  Scenario Outline: <N>_<CP>_validar que el estado del boton CANCELAR se encuentre habilitado en todo momento
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el botón CANCELAR se encuentre habilitado en todo momento
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 11    | CP011  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 125   | CP125  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 239   | CP239  |

  @boton_cancelar
  Scenario Outline: <N>_<CP>_validar que el estado del boton CANCELAR se encuentre habilitado en todo momento
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el botón CANCELAR se encuentre habilitado en todo momento
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 442   | CP442  |

  @boton_atras
  Scenario Outline: <N>_<CP>_validar que el botón ATRAS regrese al formulario ADMINISTRACION DE USUARIOS
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el botón ATRAS  regrese al formulario ADMINISTRACION DE USUARIOS
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 13    | CP013  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 127   | CP127  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 241   | CP241  |

  @seccion_info_usuarios
  Scenario Outline: <N>_<CP>_validar el contenido de la seccion INFORMACION DE USUARIO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida el contenido de la seccion INFORMACION DE USUARIO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 14    | CP014  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 128   | CP128  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 242   | CP242  |

  @seccion_info_usuarios
  Scenario Outline: <N>_<CP>_validar el contenido de la seccion INFORMACION DE USUARIO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida el contenido de la seccion INFORMACION DE USUARIO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 387   | CP387  |

  @texto_campo_obligatorio
  Scenario Outline: <N>_<CP>_validar que los campos sean obligatorios en la sección INFORMACION DE USUARIO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que los campos sean obligatorios en la sección INFORMACION DE USUARIO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 15    | CP015  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 129   | CP129  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 243   | CP243  |

  @texto_campo_obligatorio
  Scenario Outline: <N>_<CP>_validar que los campos sean obligatorios en la sección INFORMACION DE USUARIO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que los campos sean obligatorios en la sección INFORMACION DE USUARIO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 388   | CP388  |

  @textbox_correo_01
  Scenario Outline: <N>_<CP>_validar el minimo de caracteres al ingresar en el campo CORREO DE USUARIO datos manualmente y a traves de la acción pegar
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que se muestre el mensaje de error INGRESE UN CORREO VALIDO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 16    | CP016  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 130   | CP130  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 244   | CP244  |

  @textbox_correo_01
  Scenario Outline: <N>_<CP>_validar el minimo de caracteres al ingresar en el campo CORREO DE USUARIO datos manualmente y a traves de la acción pegar
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que se muestre el mensaje de error INGRESE UN CORREO VALIDO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 390   | CP390  |

  @textbox_correo_02
  Scenario Outline: <N>_<CP>_validar el maximo de caracteres al ingresar en el campo CORREO DE USUARIO datos manualmente y a traves de la acción pegar
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no deje ingresar mas de '60' caracteres en el campo correo electronico
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 17    | CP017  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 131   | CP131  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 245   | CP245  |

  @textbox_correo_02
  Scenario Outline: <N>_<CP>_validar el maximo de caracteres al ingresar en el campo CORREO DE USUARIO datos manualmente y a traves de la acción pegar
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no deje ingresar mas de '60' caracteres en el campo correo electronico
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 391   | CP391  |

  @textbox_correo_03
  Scenario Outline: <N>_<CP>_validar que el campo correo no acepte tildes ingresando datos manualmente y a través de la acción pegar
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no deje acepte tildes el campo correo electronico
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 18    | CP018  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 132   | CP132  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 246   | CP246  |

  @textbox_correo_03
  Scenario Outline: <N>_<CP>_validar que el campo correo no acepte tildes ingresando datos manualmente y a través de la acción pegar
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no deje acepte tildes el campo correo electronico
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 392   | CP392  |

  @textbox_correo_04
  Scenario Outline: <N>_<CP>_Validar que al crear un nuevo usuario NO  permita ingresar un e-mail que contengan caracteres especiales antes del @
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no permita insertar un caracter especial antes del @ en el campo correo electronico
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 19    | CP019  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 133   | CP133  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 247   | CP247  |

  @textbox_correo_04
  Scenario Outline: <N>_<CP>_Validar que al crear un nuevo usuario NO  permita ingresar un e-mail que contengan caracteres especiales antes del @
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no permita insertar un caracter especial antes del @ en el campo correo electronico
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 393   | CP393  |

  @textbox_correo_05
  Scenario Outline: <N>_<CP>_Validar que al crear un nuevo usuario permita ingresar un e-mail que contengan caracteres especiales despues del @
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema permita insertar un caracter especial despues del @ en el campo correo electronico
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 20    | CP020  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 134   | CP134  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 248   | CP248  |

  @textbox_correo_05
  Scenario Outline: <N>_<CP>_Validar que al crear un nuevo usuario permita ingresar un e-mail que contengan caracteres especiales despues del @
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema permita insertar un caracter especial despues del @ en el campo correo electronico
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 394   | CP394  |

  @textbox_nombres_01
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese menos de 3 caracteres alfanuméricos en el campo NOMBRES
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VALIDO bajo el campo NOMBRES
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 33    | CP033  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 147   | CP147  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 261   | CP261  |

  @textbox_nombres_01
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese menos de 3 caracteres alfanuméricos en el campo NOMBRES
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VALIDO bajo el campo NOMBRES
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 407   | CP407  |

  @textbox_nombres_02
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese más de 30 caracteres alfabéticos en el campo NOMBRES
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no le permita ingresar mas de '30' caracteres en el campo NOMBRES
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 34    | CP034  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 148   | CP148  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 262   | CP262  |

  @textbox_nombres_02
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese más de 30 caracteres alfabéticos en el campo NOMBRES
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no le permita ingresar mas de '30' caracteres en el campo NOMBRES
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 408   | CP408  |

  @textbox_nombres_03
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres especiales en el campo NOMBRES
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres especiales
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 35    | CP035  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 149   | CP149  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 263   | CP263  |

  @textbox_nombres_03
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres especiales en el campo NOMBRES
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres especiales
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 409   | CP409  |

  @textbox_nombres_04
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres numéricos en el campo NOMBRES
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres numéricos
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 36    | CP036  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 150   | CP150  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 264   | CP264  |

  @textbox_nombres_04
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres numéricos en el campo NOMBRES
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres numéricos
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 410   | CP410  |

  @textbox_nombres_05
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres tipo texto en el campo NOMBRES
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres tipo texto
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 37    | CP037  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 151   | CP151  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 265   | CP265  |

  @textbox_nombres_05
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres tipo texto en el campo NOMBRES
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres tipo texto
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 411   | CP411  |

  @textbox_apellido_paterno_01
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese más de '30' caracteres alfabéticos en el campo APELLIDO PATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no permita ingresar mas de '30' caracteres alfabéticos en el campo APELLIDO PATERNO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 38    | CP038  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 152   | CP152  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 266   | CP266  |

  @textbox_apellido_paterno_01
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese más de '30' caracteres alfabéticos en el campo APELLIDO PATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no permita ingresar mas de '30' caracteres alfabéticos en el campo APELLIDO PATERNO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 412   | CP412  |

  @textbox_apellido_paterno_02
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres especiales en el campo APELLIDO PATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres especiales en el campo APELLIDO PATERNO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 39    | CP039  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 153   | CP153  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 267   | CP267  |

  @textbox_apellido_paterno_02
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres especiales en el campo APELLIDO PATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres especiales en el campo APELLIDO PATERNO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 413   | CP413  |

  @textbox_apellido_paterno_03
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres numéricos en el campo APELLIDO PATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres numéricos en el campo APELLIDO PATERNO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 40    | CP040  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 154   | CP154  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 268   | CP268  |

  @textbox_apellido_paterno_03
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres numéricos en el campo APELLIDO PATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres numéricos en el campo APELLIDO PATERNO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 414   | CP414  |

  @textbox_apellido_paterno_04
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres tipo texto en el campo APELLIDO PATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres tipo texto en el campo APELLIDO PATERNO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 41    | CP041  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 155   | CP155  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 269   | CP269  |

  @textbox_apellido_paterno_04
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres tipo texto en el campo APELLIDO PATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres tipo texto en el campo APELLIDO PATERNO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 415   | CP415  |

  @textbox_apellido_materno_01
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese más de '30' caracteres alfabéticos en el campo APELLIDO MATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no permita ingresar mas de '30' caracteres alfabéticos en el campo APELLIDO MATERNO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 42    | CP042  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 156   | CP156  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 270   | CP270  |

  @textbox_apellido_materno_01
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese más de '30' caracteres alfabéticos en el campo APELLIDO MATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no permita ingresar mas de '30' caracteres alfabéticos en el campo APELLIDO MATERNO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 416   | CP416  |

  @textbox_apellido_materno_02
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres especiales en el campo APELLIDO MATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres especiales en el campo APELLIDO MATERNO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 43    | CP043  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 157   | CP157  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 271   | CP271  |

  @textbox_apellido_materno_02
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres especiales en el campo APELLIDO MATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres especiales en el campo APELLIDO MATERNO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 417   | CP417  |

  @textbox_apellido_materno_03
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres numéricos en el campo APELLIDO MATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres numéricos en el campo APELLIDO MATERNO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 44    | CP044  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 158   | CP158  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 272   | CP272  |

  @textbox_apellido_materno_03
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres numéricos en el campo APELLIDO MATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres numéricos en el campo APELLIDO MATERNO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 418   | CP418  |

  @textbox_apellido_materno_04
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres tipo texto en el campo APELLIDO MATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres tipo texto en el campo APELLIDO MATERNO
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 45    | CP045  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 159   | CP159  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 273   | CP273  |

  @textbox_apellido_materno_04
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se ingrese caracteres tipo texto en el campo APELLIDO MATERNO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema no muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres tipo texto en el campo APELLIDO MATERNO
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 419   | CP419  |

  ## Avance 12-01-2022

  @boton_siguiente_info_usuarios_01
  Scenario Outline: <N>_<CP>_Validar el comportamiento al seleccionar el botón SIGUIENTE al no tener completos todos los campos
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje CAMPO OBLIGATORIO debajo de cada campo al seleccionar el botón SIGUIENTE
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 57    | CP057  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 171   | CP171  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 285   | CP285  |

  @boton_siguiente_info_usuarios_01
  Scenario Outline: <N>_<CP>_Validar el comportamiento al seleccionar el botón SIGUIENTE al no tener completos todos los campos
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje CAMPO OBLIGATORIO debajo de cada campo al seleccionar el botón SIGUIENTE
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 445   | CP445  |

  @boton_siguiente_info_usuarios_02
  Scenario Outline: <N>_<CP>_Validar el comportamiento al seleccionar el botón SIGUIENTE al tener completos todos los campos
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el siguiente modulo al llenar  los campos e ingresar al boton SIGUIENTE
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 58    | CP058  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 172   | CP172  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 286   | CP286  |

  @boton_siguiente_info_usuarios_02
  Scenario Outline: <N>_<CP>_Validar el comportamiento al seleccionar el botón SIGUIENTE al tener completos todos los campos
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el siguiente modulo al llenar  los campos e ingresar al boton SIGUIENTE
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 446   | CP446  |

  @boton_siguiente_info_usuarios_03
  Scenario Outline: <N>_<CP>_Validar que no permita ir a la siguiente sección de información si no se ingresó todos los datos de la sección INFORMACION DE USUARIO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el cursor se mueva al primer campo dado que los datos estan incompletos y no se habilita la siguiente sección
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 59    | CP059  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 173   | CP173  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 287   | CP287  |

  @boton_siguiente_rucs_codigos_01
  Scenario Outline: <N>_<CP>_Validar que no permita ir desde sección RUC Y CODIGOS a la sección MODULOS Y OTRAS SOLICITUDES si es que no se seleccionó al menos un RUC
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema muestre el mensaje DEBES MARCAR AL MENOS UN RUC al no ingresar un RUC en la sección RUCS Y CODIGOS
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 60    | CP060  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 174   | CP174  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 288   | CP288  |

  @boton_siguiente_rucs_codigos_02
  Scenario Outline: <N>_<CP>_Validar que luego de seleccionar un RUC el mensaje de validación  'Debes marcar por lo menos 1 RUC' dejará de mostrarse
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    Then el usuario valida que el sistema ya no muestre el mensaje DEBES MARCAR AL MENOS UN RUC al ingresar un RUC en la sección RUCS Y CODIGOS
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 61    | CP061  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 175   | CP175  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 289   | CP289  |

  @acordeon_seccion_rucs_codigos_01
  Scenario Outline: <N>_<CP>_Validar que se muestre el mensaje 'Selecciona el RUC y códigos a los cuales quieres que tenga acceso el usuario'
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    Then el usuario valida que el sistema muestre el mensaje 'SELECCIONA EL RUC Y CODIGOS A LOS CUALES QUIERES QUE TENGA ACCESO EL USUARIO'
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 62    | CP062  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 176   | CP176  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 290   | CP290  |

  @acordeon_seccion_rucs_codigos_02
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando se encuentre seleccionando un RUC en la sección RUCS Y CODIGOS
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    Then el usuario valida que el sistema muestre el mensaje 'SELECCIONA EL RUC Y CODIGOS A LOS CUALES QUIERES QENGA ACCESO EL USUARIO'
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 62    | CP062  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 176   | CP176  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 290   | CP290  |

  @acordeon_seccion_rucs_codigos_03
  Scenario Outline: <N>_<CP>_Validar que se muestre una lista de numeros de RUC y los botones Todos y Seleccionar al lado de cada uno de ellos
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    Then el usuario valida que el sistema muestre una lista con RUCS y los botones TODOS Y SELECCIONAR
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 65    | CP065  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 179   | CP179  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 293   | CP293  |

    ## Avance 17-01-2023
  @acordeon_seccion_rucs_codigos_04
  Scenario Outline: <N>_<CP>_Validar que se muestre habilitado los botones TODOS y SELECCIONAR al lado del RUC seleccionado.
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    And el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'
    Then el usuario valida que el sistema muestre habilitado los botones 'TODOS Y SELECCIONAR'
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 66    | CP066  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 180   | CP180  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 294   | CP294  |

  @acordeon_seccion_rucs_codigos_05
  Scenario Outline: <N>_<CP>_Validar el comportamiento al seleccionar el botón "SELECCIONAR"
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    And el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'
    Then el usuario valida que el sistema muestre un popup que contenta un titulo y subtitulo al interactuar con el botón 'SELECCIONAR'
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 67    | CP067  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 181   | CP181  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 295   | CP295  |

    ## Avance 19-01-2023

  @input_filtro_busqueda_codigo_01
  Scenario Outline: <N>_<CP>_Validar el comportamiento al ingresar caracteres numericos como codigo de comercio valido en el filtro 'BUSQUEDA POR CÓDIGO'
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    And el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'
    Then el usuario valida que el sistema actualice la lista de comercios al buscar por codigo
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 68    | CP068  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 182   | CP182  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 296   | CP296  |

  @tabla_codigo_nombreComercial_01
  Scenario Outline: <N>_<CP>_Validar el comportamiento al seleccionar un comercio de los comercios mostrados en el popup
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    And el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'
    Then el usuario valida que el sistema actualice la grilla de la tabla con el codigo de comercio seleccionado
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 69    | CP069  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 183   | CP183  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 297   | CP297  |

  @tabla_codigo_nombreComercial_02
  Scenario Outline: <N>_<CP>_Validar el comportamiento al seleccionar la opción 'Seleccionar todos'
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    And el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'
    Then el usuario valida que el sistema muestre todos los codigos en la tabla de codigos seleccionados
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 70    | CP070  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 184   | CP184  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 298   | CP298  |

  @boton_aceptar_popup_busqueda_codigos_01
  Scenario Outline: <N>_<CP>_Validar el estado del boton 'ACEPTAR' al no seleccionar algún comercio
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    And el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'
    Then el usuario valida que el sistema muestre deshabilitado el boton ACEPTAR al no seleccionar algún comercio
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 71    | CP071  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 185   | CP185  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 299   | CP299  |

  @boton_aceptar_popup_busqueda_codigos_02
  Scenario Outline: <N>_<CP>_Validar el estado del boton 'ACEPTAR' al seleccionar un comercio
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    And el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'
    Then el usuario valida que el sistema muestre habilitado el boton ACEPTAR al seleccionar un comercio
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 72    | CP072  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 186   | CP186  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 300   | CP300  |

    ## Avance 23-01-2023
  @acordeon_rucs_codigos_info_codigos_seleccionados
  Scenario Outline: <N>_<CP>_Validar que al  seleccionar un comercio y darle click al botón ACEPTAR se muestre la cantidad de comercios seleccionados  en el listado de RUCs de  la pantalla CREAR USUARIO
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    And el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'
    And el usuario selecciona el codigo a los que dara acceso
    Then el usuario valida que el sistema muestre la cantidad de codigos marcados al seleccionar el boton ACEPTAR
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 73    | CP073  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 187   | CP187  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 301   | CP301  |

  @acordeon_rucs_codigos_boton_seleccionar
  Scenario Outline: <N>_<CP>_Validar que al seleccionar un comercio y darle click al botón ACEPTAR se muestre el botón SELECCIONAR de color naranja
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    And el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'
    And el usuario selecciona el codigo de comercio a los que dara acceso
    Then el usuario valida que el sistema muestre el botón SELECCIONAR de color naranja
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 74    | CP074  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 188   | CP188  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 302   | CP302  |

  @acordeon_secciones
  Scenario Outline: <N>_<CP>_Validar el comportamiento cuando el usuario desee cambiar un valor de una sección anterior y no deje vacío un campo
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a la opción 'CREAR NUEVO USUARIO'
    And el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'
    And el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'
    And el usuario regresa a la sección INFORMACION DE USUARIO y modifica un campo
    Then el usuario valida que el sistema no bloquee el pasar a la siguiente sección
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 75    | CP075  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 189   | CP189  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 303   | CP303  |

    ## Avance 23-01-2023

