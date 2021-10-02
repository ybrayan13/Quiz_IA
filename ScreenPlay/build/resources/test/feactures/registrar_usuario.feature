# Autor: yhors.b@tcs.com

Feature: yo como usuario deseo crear una cuenta en Advantage

  @CuentaExitosa
  Scenario: Creacion de cuenta exitosa
    Given El usuario se encuentra en la pagina
    When El usuario ingresa la informacion Brayan
      | firstName | lastName | email         | month    | day | year | password    | confirmpassword |
      | yhors     | brayan   | yhors@tcs.com | October  | 26  | 1997 | Medellin*13 | Medellin*13     |
      | diana     | carolina | diana@tcs.com | December | 25  | 1996 | Redmi*      | Redmi*          |

    Then El usuario vera su nombre en el perfil

  @CuentaFallida
  Scenario: Creacion de cuenta fallida
    Given El usuario ya se encuentra en la pagina
    When El usuario ingresa sus credenciales
      | firstName | lastName | email         | month    | day | year | password  | confirmpassword |
      | yhors     | brayan   | yhors@tcs.com | October  | 26  | 1997 | Medellin* | Medellin*       |
      | diana     | carolina | diana@tcs.com | December | 25  | 1996 | Redmi*    | Redmi*          |
    Then El usuario obtiene un mensaje de error