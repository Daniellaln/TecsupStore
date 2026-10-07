# Lab S06 – TECSUP Store (DropdownMenu + NavigationDrawer)

**Autora:** Daniella León
**Curso:** Desarrollo de Aplicaciones Móviles – Tecsup

## Descripción
App en Jetpack Compose con una tienda de productos. Cada tarjeta tiene un ícono de
3 puntos que abre un DropdownMenu con Favoritos, Compartir y Reportar. Desde el ícono
de menú de la barra superior se abre un NavigationDrawer con 4 destinos (Inicio, Mis
pedidos, Favoritos, Perfil) más Cerrar sesión, encabezado con las iniciales del usuario,
destino activo resaltado y un badge con la cantidad de favoritos.

## Capturas
| DropdownMenu | NavigationDrawer |
|---|---|
| ![menu](capturas/dropdown.png) | ![drawer](capturas/drawer.png) |

## Estructura de archivos
```
data/            Producto.kt, DatosProductos.kt, Usuario.kt
util/            Formato.kt
ui/components/   BarraSuperior.kt, TarjetaProducto.kt, AppDrawer.kt, EncabezadoDrawer.kt
ui/navigation/   Destino.kt, AppNavegacion.kt
ui/screens/      PantallaInicio.kt, PantallaFavoritos.kt, PantallaPedidos.kt,
                 PantallaPerfil.kt, PantallaMensaje.kt
```

## Preguntas de reflexión

**¿Por qué el DropdownMenu se declara dentro de un Box junto al ícono que lo activa?**
Porque el menú se posiciona respecto al contenedor donde está declarado. Al ponerlo en
el mismo Box que el IconButton, aparece pegado a los 3 puntos de esa tarjeta. Si se
declarara suelto en la pantalla, saldría en otra posición y además una sola instancia
tendría que saber a qué producto pertenece.

**¿Qué diferencia de alcance hay entre el DropdownMenu y el NavigationDrawer?**
El DropdownMenu es contextual: sus opciones actúan sobre un solo producto (marcarlo
favorito, compartirlo, reportarlo). El NavigationDrawer es de navegación global: cambia
la pantalla completa que ve el usuario en toda la app.

**¿Cómo estructuré el código para que el contador de favoritos del drawer se entere de
lo que pasa en el DropdownMenu de cada producto?**
Subí el estado (state hoisting). La lista de favoritos vive en `AppNavegacion`, que es el
composable padre del drawer y de las pantallas. Las tarjetas no guardan el favorito: solo
avisan con `onToggleFavorito`, y el drawer recibe `cantidadFavoritos` desde el mismo
estado. Como es un `mutableStateListOf`, cualquier cambio recompone al drawer y a la lista.

**¿Qué tuve que corregir del código que me generó la IA para el badge de favoritos?**
Al inicio el favorito se guardaba dentro de la tarjeta con un `remember` propio, así que
el contador del drawer nunca cambiaba. Tuve que sacar ese estado a `AppNavegacion` y pasar
la información hacia abajo. También cambié la lista normal por `mutableStateListOf` para
que la pantalla se redibujara, y puse el badge condicionado a que haya al menos 1 favorito.

## Observaciones
- El DropdownMenu necesita su propio `expanded` por tarjeta; con un solo estado compartido se abrían todos los menús a la vez.
- El drawer se cierra con corrutinas (`scope.launch { drawerState.close() }`), no con una llamada directa, porque la animación es suspendida.

## Conclusiones
- En la Fase 1 me costó más ubicar dónde declarar el menú; en la Fase 2 ya tenía claro que la posición depende del contenedor y avancé más rápido.
- Elevar el estado hizo que el badge, la pantalla de favoritos y las tarjetas se mantengan sincronizados sin código extra, y creo que es el patrón que más voy a reutilizar.
