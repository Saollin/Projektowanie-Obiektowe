
public class Main {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole (5);
        RoundPeg rpeg = new RoundPeg (5);

        System.out.println(hole.fits(rpeg)); // true

        SquarePeg smallSqpeg = new SquarePeg (5);
        SquarePeg largeSqpeg = new SquarePeg (10);


        SquarePegAdapter smallSqpegAdapter = new SquarePegAdapter (smallSqpeg);
        SquarePegAdapter largeSqpegAdapter = new SquarePegAdapter (largeSqpeg);

        System.out.println(hole.fits(smallSqpegAdapter));//true
        System.out.println(hole.fits( largeSqpegAdapter));//false

    }
}
