package back.services;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.http.HttpTester.Message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import back.models.Graphe;
import back.models.GrapheJson;

public class DijkstraService {
    public static void getShortPath(Context ctx) {   
        GrapheJson GJson; Graphe g;
        try{
            GJson = ctx.bodyAsClass(GrapheJson.class);
            g = GJson.createGraphe();

            // Recherche du chemin optimal

            ctx.status(200).json("Message added succesfully ...");
        }catch (Exception e){
            e.printStackTrace();
            ctx.status(500).json(e.getMessage());
        }
    }
}
