public class StringServiceImpl extends StringServicePOA{
    public String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String convertToUppercase(String str) {
        return str.toUpperCase();
    }
}
