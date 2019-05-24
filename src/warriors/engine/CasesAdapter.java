package warriors.engine;

import warriors.engine.Cases;
import com.google.gson.*;
import java.lang.reflect.Type;

public class CasesAdapter implements JsonSerializer<Cases>, JsonDeserializer<Cases> {
    @Override
    public JsonElement serialize(Cases src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", context.serialize(src, src.getClass()));

        return result;
    }

    @Override
    public Cases deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            return context.deserialize(element, Class.forName("warriors.engine." + type));
        } catch (JsonParseException | ClassNotFoundException  cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
    }
}