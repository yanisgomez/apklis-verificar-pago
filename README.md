# apklis-verificar-pago
API Java Para Verificar Los Pagos De Apps En Apklis.



# Instalación


 • Descarga El Archivo ApklisCheckPayment.java Y
   Agrégalo A La Carpeta Java De Tu Proyecto.



# Uso

 • Cambia El Package Del Archivo ApklisCheckPayment.java
   Por El Package De Tu App.

 
 • Es Necesario Tener Instalada La App De Apklis Y 
   Una Sesión Iniciada Con Las Credenciales Del
   Usuario Que Compró La App. De No Ser Así
   username Será null y paid Será false.


 • Verificar Pago En Java.


 
```java


ApklisCheckPayment checkpaid = new ApklisCheckPayment(this, this.getPackageName());
String username = checkpaid.getUserName();
boolean paid = checkpaid.getPaid();


```

   
  
   
