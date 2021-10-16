# Guess Number

El objetivo de este juego es permitir al usuario adivinar un número entre 1 y 100 en una serie de intentos que el usuario indicará. Esta aplicación consta de tres <code>Activity</code> o interfaces gráficas:

## ConfigActivity
Esta será la <code>Activity</code> principal al abrir la aplicación, donde el usuario debe introducir su **nombre** y el **número de intentos** que quiere tener para adivinarlo.

Los errores a la hora de introducir correctamente los valores en los campos está controlado, siendo el número de intentos obligatoriamente un número no superior a 100 para permitir al usuario perder y no tener una oportunidad para cada número.

Al pulsar el botón **Jugar** se validarán los campos y si todo se ha introducido correctamente llevará al usuario a la <code>Activity</code> del juego.

<img src="https://raw.githubusercontent.com/JoseRelUmbra/GuessNumber/master/app/src/img/ConfigActivity.png"/>

## PlayActivity 
Esta será la <code>Activity</code> en la que se deberá **adivinar** el **número secreto**, teniendo en cuenta los **intentos** introducidos previamente por el usuario.

Cada vez que se pulse **Comprobar**, si es un número válido se bloqueará dicho botón y el texto, dejando activo el botón **Reintentar** activado para volver a introducir un número de nuevo, consumiendo 1 intento por cada comprobación del número. Teniendo en cuenta que si no es un número se avisará al usuario mediante un mensaje y no comprobará nada.

<img src="https://raw.githubusercontent.com/JoseRelUmbra/GuessNumber/master/app/src/img/PlayActivity.png"/>

## EndPlayActivity

Esta será la <code>Activity</code> final que mostrará por pantalla el **número secreto** y el **número de intentos restantes** que dependiendo de si el usuario **gastó** o no sus intentos, saldrá un **mensaje** que indicará al usuario si ha **ganado o perdido** siendo este el final del juego.

<img src="https://raw.githubusercontent.com/JoseRelUmbra/GuessNumber/master/app/src/img/EndPlayActivity.png"/>
