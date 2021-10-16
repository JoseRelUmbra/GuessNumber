package com.joserelumbra.guessnumber.data.model;


import android.app.Application;
import java.io.Serializable;

/**
 * Clase usuario que contiene el tipo de dato del jugador del juego GuessNumber.
 */
public class User implements Serializable{
    private String nombre; //Nombre del jugador
    private Integer intentos; //Intentos que tiene el jugador para adivinar el número
    private Integer guess; //Número secreto que tendrá que averiguar el jugador

    /**
     * Constructor vacío de tipo User.
     */
    public User(){

    }

    /**
     * Constructor de tipo User que contendrá todos los campos de un usuario
     * preparado para el juego.
     * @param nombre nombre del usuario.
     * @param intentos intentos que tiene el usuario para jugar.
     */
    public User(String nombre, Integer intentos){
        this.nombre = nombre;
        this.intentos = intentos;
    }

    /**
     * Devuelve el valor del nombre del usuario.
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el total de intentos que posee el usuario.
     * @return
     */
    public Integer getIntentos() {
        return intentos;
    }

    /**
     * Devuelve el número secreto que el jugador tiene que averiguar
     * @return
     */
    public Integer getGuess() {
        return guess;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre Nuevo valor que tendrá este campo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el nº de intentos que tendrá el usuario para el juego.
     * @param intentos Nuevo valor que tendrá el campo.
     */
    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    /**
     * Establece el estado del jugador, será el campo que más cambie de todos.
     * @param guessNumber Establece valor del número secreto.
     */
    public void setGuess(Integer guessNumber) {
        this.guess = guessNumber;
    }
}
