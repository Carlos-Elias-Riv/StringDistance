public class PruebaDistanciaStrings {

    public static int edit(String s1, String s2, int cont) {
        if(s1.length()== 0 || s2.length()== 0)
            return cont +s1.length() + s2.length();
        if (s1.charAt(0) == s2.charAt(0)) {
            return edit(s1.substring(1), s2.substring(1), cont); // nada
        }

        int sus = edit(s1.substring(1), s2.substring(1), cont +1);
        int ins = edit(s1.substring(1), s2, cont +1);
        int bor = edit(s1, s2.substring(1), cont +1);

        return min(sus, ins, bor);

    }

    private static int min(int i, int j, int k) {
        if(j <= i && j<= k)
            return j;
        else if(k <= i && k<= j)
            return k;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(edit("ernandof", "fernando", 0)); // valor esperado 2
        System.out.println(edit("hola", "gggg", 0)); // valor esperado 4
        System.out.println(edit("a", "tres", 0)); // valor esperado 4
    }
}
