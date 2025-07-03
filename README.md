# Mobile Automation Final Practice

Este proyecto es una práctica final de automatización móvil desarrollada con Java, Appium y TestNG, cuyo objetivo es consolidar todos los conocimientos aprendidos durante el curso de automatización móvil. Se centra en la automatización de pruebas funcionales para la aplicación de demostración **WebdriverIO Native Demo App**, disponible en Android.

El enfoque principal es garantizar la independencia de cada caso de prueba, aplicando buenas prácticas como el patrón **Page Object Model (POM)** y el uso de **PageFactory**, manteniendo una estructura clara, reutilizable y escalable.

---

## Tecnologías y herramientas utilizadas

- **Java 17**
- **Appium Java Client 8.5.1**
- **Selenium WebDriver 4.8.3**
- **TestNG 7.10.2**
- **Maven** (gestión del ciclo de vida del proyecto)
- **Android Studio Emulator** (dispositivo de prueba)
- **WebdriverIO Demo App APK**: [`android.wdio.native.app.v1.0.8.apk`](https://github.com/webdriverio/native-demo-app/releases)

---

## Requisitos previos

- Java JDK 17 instalado
- Appium server ejecutándose localmente (`http://127.0.0.1:4723/wd/hub`)
- Android Studio con un emulador configurado (o dispositivo físico)
- APK descargado y ubicado en `src/test/resources/`
- Node.js instalado para Appium (opcional)
- Variables de entorno correctamente configuradas (ANDROID_HOME, etc.)

---

## Estructura del Proyecto

mobile-automation-java/

├── .idea/

│   ├── .gitignore

│   ├── compiler.xml

│   ├── encodings.xml

│   ├── jarRepositories.xml

│   ├── misc.xml

│   ├── workspace.xml├── pom.xml

├── src/

│   ├── main/

│   │   └── java/

│   │       └── mobile/

│   │           └── utils/

│   │               ├── CapabilitiesFactory.java

│   │               └── DriverManager.java


│
│   ├── test/

│   │   └── java/

│   │       └── mobile/

│   │           ├── pages/

│   │           │   ├── BasePage.java

│   │           │   ├── LoginPage.java

│   │           │   ├── MenuPage.java

│   │           │   ├── RegisterPage.java

│   │           │   └── SwipePage.java

│   │           └── test/

│   │               ├── BaseTest.java

│   │               ├── LoginTest.java

│   │               ├── NavigationMenuTest.java

│   │               ├── RegisterTest.java

│   │               └── SwipeTest.java

│   │ └── resources/

│   │     └── android.wdio.native.app.v1.0.8.apk

└── testng.xml

└── pom.xml 

# Mobile Automation Final Practice

Este proyecto es una práctica final de automatización móvil desarrollada con Java, Appium y TestNG, cuyo objetivo es consolidar todos los conocimientos aprendidos durante el curso de automatización móvil. Se centra en la automatización de pruebas funcionales para la aplicación de demostración **WebdriverIO Native Demo App**, disponible en Android.

El enfoque principal es garantizar la independencia de cada caso de prueba, aplicando buenas prácticas como el patrón **Page Object Model (POM)** y el uso de **PageFactory**, manteniendo una estructura clara, reutilizable y escalable.

---

## Tecnologías y herramientas utilizadas

- Java 17
- Appium Java Client 8.5.1
- Selenium WebDriver 4.8.3
- TestNG 7.10.2
- Maven (gestión del ciclo de vida del proyecto)
- Android Studio Emulator (dispositivo de prueba)
- WebdriverIO Demo App APK: [`android.wdio.native.app.v1.0.8.apk`](https://github.com/webdriverio/native-demo-app/releases)

---

## Requisitos previos

- Java JDK 17 instalado
- Appium server ejecutándose localmente (`http://127.0.0.1:4723/wd/hub`)
- Android Studio con un emulador configurado (o dispositivo físico)
- APK descargado y ubicado en `src/test/resources/`
- Node.js instalado para Appium (opcional)
- Variables de entorno correctamente configuradas (ANDROID_HOME, etc.)

---


## Cómo ejecutar el proyecto
Cómo ejecutar el proyecto
Asegúrate de tener corriendo el emulador Pixel_6_API_33 desde Android Studio.
1. Instalar dependencias:
Bash:
mvn clean install

2. Ejecutar todos los tests:
Bash:
mvn clean test

3.Ejecutar testng.xml directamente:
mvn clean test -Dtest=LoginTest

Se han implementado los 4 escenarios requeridos, cumpliendo con todos los pasos solicitados en el documento original:


1. Navegación en la barra de menú inferior
   
•	Se navega por todas las secciones (Home, WebView, Login, Forms, Swipe, Drag).

•	Se verifica que cada sección se carga correctamente mediante aserciones básicas.

•	Independiente y reutilizable.



3. Registro exitoso (Sign Up)
   
•	Se navega desde Login hacia el formulario de registro.

•	Se completa el registro usando datos definidos (puede mejorarse con emails aleatorios).

•	Se valida el mensaje "You successfully signed up!".

•	Confirmación con botón OK.

•	Test independiente y reutilizable.



4. Inicio de sesión exitoso (Login)
   
•	Se navega a la vista de Login.

•	Se completan los campos email y contraseña.

•	Se valida el mensaje "You are logged in!".

•	Confirmación con botón OK.



5. Swipe y scroll
   
•	Se accede a la sección Swipe desde el menú.

•	Se hace swipe horizontal en el carrusel (derecha e izquierda).

•	Se hace scroll vertical hasta encontrar el texto "You found me!!!".

•	Se verifica su visibilidad.


Cumplimiento de los requerimientos 

•	Instalar la app en dispositivo/emulador	

•	Automatizar 4 escenarios

•	Mantener independencia entre los tests

•	Uso de Page Object Model y PageFactory

•	Uso de Appium con capacidades bien definidas

•	Manejo de assertions para validar éxito de los flujos

•	Configuración con Maven y ejecución vía TestNG

•	testng.xml funcional

•	Uso de buenas practicas.


Madelin Alzate.
Proyecto realizado como parte de la práctica final de automatización 
