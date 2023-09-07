package primitive_classes;

public class TypeChecker {
    public static <X> String getType(X var){
        if (var instanceof String) {
            return "String";
        }else if(var instanceof Integer) {
            return "Integer";
        }else if(var instanceof Float) {
            return ("Float");
        }else if(var instanceof Boolean) {
            return ("Boolean");
        }else if(var instanceof Double) {
            return ("Double");
        }
        return "";
    }
}