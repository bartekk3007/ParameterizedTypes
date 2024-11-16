import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            // Uzyskanie pola stringList z klasy MyClass
            Field stringListField = MyClass.class.getDeclaredField("stringList");
            // Uzyskanie typu tego pola
            Type stringListType = stringListField.getGenericType();
            // Sprawdzenie, czy typ jest ParameterizedType
            if (stringListType instanceof ParameterizedType)
            {
                ParameterizedType parameterizedType = (ParameterizedType) stringListType;
                // Uzyskanie surowego typu (raw type)
                System.out.println("Raw type: " + parameterizedType.getRawType());
                // Uzyskanie argumentów typu generycznego
                Type[] typeArguments = parameterizedType.getActualTypeArguments();
                for (Type typeArgument : typeArguments)
                {
                    System.out.println("Type argument: " + typeArgument.getTypeName());
                }
            }
            // Powtarzamy dla pola map
            Field mapField = MyClass.class.getDeclaredField("map");
            Type mapType = mapField.getGenericType();
            if (mapType instanceof ParameterizedType)
            {
                ParameterizedType parameterizedType = (ParameterizedType) mapType;
                System.out.println("Raw type: " + parameterizedType.getRawType());
                Type[] typeArguments = parameterizedType.getActualTypeArguments();
                for (Type typeArgument : typeArguments)
                {
                    System.out.println("Type argument: " + typeArgument.getTypeName());
                }
            }
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
    }
}