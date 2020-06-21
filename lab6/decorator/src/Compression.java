public class Compression {
    public static String compress (String string) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {
            int count = 1;
            while (i + 1 < string.length()
                    && string.charAt(i) == string.charAt(i + 1)) {
                count++;
                i++;
            }

            if (count > 1) {
                stringBuffer.append(count);
            }

            stringBuffer.append(string.charAt(i));
        }

        return stringBuffer.toString();
    }

    public static String decompress (String string){

        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i<string.length(); i++){
            int count = string.charAt(i) - 48;
            if(count>0 && count<10){
                i++;
                for(int j = count; j>0; j--){
                    stringBuffer.append(string.charAt(i));
                }
            }
            else{
                stringBuffer.append(string.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}
