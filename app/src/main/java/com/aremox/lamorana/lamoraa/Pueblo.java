package com.aremox.lamorana.lamoraa;

/**
 * Created by ivan on 23/9/15.
 */


public class Pueblo
{
    private String nombre;
    private String subtitulo;
    private String color;

    public Pueblo(String tit, String sub){
        nombre = tit;
        subtitulo = sub;
    }
    public Pueblo(String tit, String sub, String col){
        nombre = tit;
        subtitulo = sub;
        color = col;
    }

    public String getNombre(){
        return nombre;
    }

    public String getSubtitulo(){
        return subtitulo;
    }

    public String getColor() {
        return color;
    }
}
