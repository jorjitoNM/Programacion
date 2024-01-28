public class Television extends Articulo {
    private double pulgadas;
    private boolean isOLED;
    private double sRGB;
    private int vAndroid;

    public Television (Tienda tienda) {
        super(tienda);
        pulgadas = Math.random()*40+49;
        isOLED = (Math.random()*1+1==1)?true:false;
        sRGB = Math.random()*43+87;
        vAndroid = (int)(Math.random()*4+11);
    }

    public Television (Tienda tienda,double precio,double pulgadas,boolean isOLED,double sRGB,int vAndroid) {
        super(tienda,precio);
        this.pulgadas = pulgadas;
        this.isOLED = isOLED;
        this.sRGB = sRGB;
        this.vAndroid = vAndroid;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public boolean isOLED() {
        return isOLED;
    }

    public void setOLED(boolean OLED) {
        isOLED = OLED;
    }

    public double getsRGB() {
        return sRGB;
    }

    public void setsRGB(double sRGB) {
        this.sRGB = sRGB;
    }

    public int getvAndroid() {
        return vAndroid;
    }

    public void setvAndroid(int vAndroid) {
        this.vAndroid = vAndroid;
    }
}
