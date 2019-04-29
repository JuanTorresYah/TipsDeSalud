package com.example.tipsdesalud.modelo;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ModeloArticulos {

public static final List<Articulo> ITEMS = new ArrayList<Articulo>();

public static final Map<String, Articulo> MAPA_ITEMS = new HashMap<String, Articulo>();


static {
    agregarItem(new Articulo(generarId(),
            "10 Plantillas Para Determinar Tus Necesidades Calóricas",
            "Descarga nuestras plantillas para Microsoft Excel que te permitirán, calcular exactamente...",
            "10 de Enero", "http://www.puntosingular.mx/imagenesarticulo1.jpg"));

    agregarItem(new Articulo(generarId(),
            "¿Qué Tan Malo Es Consumir Chocolate?",
            "Si aún no has podido resolver tus dudas sobre comer chocolate, entonces este artículo es para ti...",
            "11 de Enero","http://www.puntosingular.mx/imagenesarticulo2.jpg"));

    agregarItem(new Articulo(generarId(),
            "Guía Para Identificar Alimentos Con Trigo Perjudiciales ",
            "Aprende a distinguir aquellos alimentos que están hechos de trigo mal procesado...",
            "12 de Enero","http://www.puntosingular.mx/imagenesarticulo3.jpg"));

    agregarItem(new Articulo(generarId(),
            "Descubre Qué Harían 10 Minutos De Ejercicio Diario En Tu Cuerpo",
            "Entra y descubre los beneficios de realizar una rutina de 10 minutos los 7 días...",
            "13 de Enero","http://www.puntosingular.mx/imagenesarticulo4.jpg"));


    agregarItem(new Articulo(generarId(),
            "Aumentando Las Defensas Del Cuerpo Con Frutos Rojos",
            "Los frutos rojos frecuentemente son ignorados por la mayoría de las personas, pero hoy te mostraremos...",
            "14 de Enero","http://www.puntosingular.mx/imagenesarticulo5.jpg"));


    agregarItem(new Articulo(generarId(),
            "5 Recetas Bajas En Grasa Para El Almuerzo",
            "Variar las recetas a la hora de alimentarse permite obtener distintos beneficios dependiendo del alimento...",
            "15 de Enero","http://www.puntosingular.mx/imagenesarticulo6.jpg"));


    agregarItem(new Articulo(generarId(),
            "Combina  Cardio + Fuerza Para Obtener Verdaderos Resultados",
            "Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...",
            "16 de Enero","http://www.puntosingular.mx/imagenesarticulo7.jpg"));


    agregarItem(new Articulo(generarId(),
            "Planificador Semanal Para Optimizar Tu Dieta",
            "Descarga nuestra nueva plantilla para prácticar buenos hábitos alimenticios. Se trata de...",
            "17 de Enero","http://www.puntosingular.mx/imagenesarticulo8.jpg"));


    agregarItem(new Articulo(generarId(),
            "Las 30 Razones De Por Que Superman Come Cacahuates ",
            "Los frutos secos han sido desde la antiguedad la principal fuente de  proteínas para muchas civilizaciones...",
            "18 de Enero","http://www.puntosingular.mx/imagenesarticulo9.jpg"));
   }

   @NonNull
   private static String generarId(){
    return UUID.randomUUID().toString();
   }

   private static void agregarItem(Articulo item){
    ITEMS.add(item);
    MAPA_ITEMS.put(item.id, item);
   }

   public static class Articulo {
       public final String id;
       public final String titulo;
       public final String descripcion;
       public final String fecha;
       public final String urlMiniatura;

       public Articulo(String id, String titulo, String descripcion, String fecha, String urlMiniatura){
           this.id = id;
           this.titulo = titulo;
           this.descripcion = descripcion;
           this.fecha = fecha;
           this.urlMiniatura = urlMiniatura;
       }
    }
}
