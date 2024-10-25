package persistence;

import org.json.JSONObject;

//JsonSerializationDemo PROJECT WAS REFERRED TO IN ORDER TO WRITE THIS CODE.
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
