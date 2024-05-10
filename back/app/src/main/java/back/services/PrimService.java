package back.services;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jetty.http.HttpTester.Message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import back.models.Arret;
import back.models.Graphe;
import back.models.GrapheJson;
import back.models.Noeud;
import back.models.Prim;


public class PrimService {
    public static void getShortPath(Context ctx) {   
        GrapheJson GJson; Graphe g;
        System.out.println("Prim algorithm");
        try{
            GJson = ctx.bodyAsClass(GrapheJson.class);
            g = GJson.createGraphe();

            //Recherche du chemin optimal
            ctx.status(200).json(Prim.primMST(g));
        }catch (Exception e){
            System.out.println("Oups erreur...");
            //e.printStackTrace();
            ctx.status(500).json(e.getMessage());
        }
    }
}
