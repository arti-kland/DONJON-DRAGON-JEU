package warriors.engine;

import com.google.gson.*;

import java.lang.reflect.Type;



public class CasesAdapter implements JsonSerializer<Cases>, JsonDeserializer<Cases> {
    /**
     * methode add type to object and Json file for prepare rebuild map
     * @param src
     * @param typeOfSrc
     * @param context
     * @return result = new object with type (class) add
     */
    @Override
    public JsonElement serialize(Cases src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", context.serialize(src, src.getClass()));

        return result;
    }

    /**
     * method help to rebuild a map from the Json file by typing the case
     * @param json
     * @param typeOfT
     * @param context
     * @return context.deserialize
     * @throws JsonParseException
     */
    @Override
    public Cases deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            return context.deserialize(element, Class.forName("warriors.engine." + type));
        } catch (JsonParseException | ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
    }
}