Feature: Compra de productos en la tienda en línea

  Background: El usuario está en la página principal y ha iniciado sesión
    Given Estoy en la pagina principal

  Scenario: Usuario realiza la compra de dos productos, visualiza el carrito, y completa la compra
    When Selecciono el primer producto
    And Agrego el producto al carrito
    And Vuelvo a la pagina principal
    And Selecciono el segundo producto
    And Agrego el producto al carrito
    When Estoy en la pagina del carrito
    And Debería ver 2 productos en el carrito
    When Abro el formulario de compra
    And Lleno el campo Name con el dato Zamir Enriquez
    And Lleno el campo Country con el dato Bolivia
    And Lleno el campo City con el dato La Paz
    And Lleno el campo Credit Card con el dato 5499224400552244
    And Lleno el campo Month con el dato 12
    And Lleno el campo Year con el dato 2028
    When Hago click en el botón de realizar pedido
    Then Debería ver la alerta de confirmación de compra y finalizar la compra
