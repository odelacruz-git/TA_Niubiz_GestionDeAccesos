@F_ADMIN_USUARIOS
Feature: FUNCIONALIDAD ADMINISTRAR USUARIOS
  Background:
 #   Given el usuario se encuentra logueado a la web de Nel con perfil <profile>

  @boton_descargar_reporte
  Scenario Outline: <N>_<CP>_validar que en la cabecera se muestre el botón 'DESCARGAR REPORTE'
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    Then el usuario valida que se muestre el Botón 'DESCARGAR REPORTE'
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 1     | CP001  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 115   | CP115  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 229   | CP229  |

  @boton_descargar_reporte
  Scenario Outline: <N>_<CP>_validar que en la cabecera se muestre el botón 'DESCARGAR REPORTE'
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa el RUC de prueba
    And el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    Then el usuario valida que se muestre el Botón 'DESCARGAR REPORTE'
    @niubizVisor
    Examples: data
      | N     | CP     |
      | 346   | CP346  |

  @boton_descargar_reporte
  Scenario Outline: <N>_<CP>_validar que en la cabecera NO se muestre el botón 'DESCARGAR REPORTE'
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario valida que se encuentre en la pagina 'Administrar Usuarios'
    Then el usuario valida que NO se muestre el Botón 'DESCARGAR REPORTE'
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 371   | CP371  |

  @boton_crear_usuario
  Scenario Outline: <N>_<CP>_validar que en la cabecera se muestre el botón 'CREAR NUEVO USUARIO'
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    Then el usuario valida que se muestre el Botón 'CREAR USUARIO'
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 2     | CP002  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 116   | CP116  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 230   | CP230  |

  @titulo_administrar_usuarios
  Scenario Outline: <N>_<CP>_validar que en la cabecera se muestre el titulo 'ADMINISTRAR USUARIOS'
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    Then el usuario valida que se muestre el título 'ADMINISTRAR USUARIOS'
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 3     | CP003  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 117   | CP117  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 231   | CP231  |

  @titulo_administrar_usuarios
  Scenario Outline: <N>_<CP>_validar que en la cabecera se muestre el titulo 'ADMINISTRAR USUARIOS'
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa el RUC de prueba
    And el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    Then el usuario valida que se muestre el título 'ADMINISTRAR USUARIOS'
    @niubizVisor
    Examples: data
      | N     | CP     |
      | 344   | CP344  |

  @placeholder_buscador
  Scenario Outline: <N>_<CP>_validar que se muestre el placeholder en la barra de busqueda
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    Then el usuario valida que se muestre el placeholder en la barra de busqueda
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 4     | CP004  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 118   | CP118  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 232   | CP232  |

  @placeholder_buscador
  Scenario Outline: <N>_<CP>_validar que se muestre el placeholder en la barra de busqueda
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ingresa el RUC de prueba
    And el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    Then el usuario valida que se muestre el placeholder en la barra de busqueda
    @niubizVisor
    Examples: data
      | N     | CP     |
      | 345   | CP345  |

  @placeholder_buscador
  Scenario Outline: <N>_<CP>_validar que se muestre el placeholder en la barra de busqueda
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario valida que se encuentre en la pagina 'Administrar Usuarios'
    Then el usuario valida que se muestre el placeholder en la barra de busqueda
    @niubizMesaServicio
    Examples: data
      | N     | CP     |
      | 378   | CP378  |
      | 457   | CP457  |

  @txt_mi_usuario
  Scenario Outline: <N>_<CP>_validar que se muestre el placeholder en la barra de busqueda
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    Then el usuario valida que se muestre datos de 'MI USUARIO'
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 5     | CP005  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 119   | CP119  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 233   | CP232  |

  @txt_dni_email
  Scenario Outline: <N>_<CP>_validar que se muestre el DNI y el CORREO del usuario
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    Then el usuario valida que se muestre datos de DNI y EMAIL
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 6     | CP006 |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 120   | CP120  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 234   | CP234  |

  @boton_cancelar
  Scenario Outline: <N>_<CP>_validar el estado del botón guardar al ingresar al modulo CREAR USUARIO por primera vez
    Given el usuario se encuentra logueado a la web de Nel
    When el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'
    And el usuario ingresa a editar un usuario en el icono lapiz
    Then el usuario valida que el botón CANCELAR se encuentre habilitado
    @comercioAdministrador
    Examples: data
      | N     | CP     |
      | 110   | CP110  |
    @comercioAccesoTotal
    Examples: data
      | N     | CP     |
      | 224   | CP224  |
    @comercioAccesoPersonalizado
    Examples: data
      | N     | CP     |
      | 338   | CP338  |