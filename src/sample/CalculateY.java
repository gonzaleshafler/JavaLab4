package sample;

public class CalculateY {


    double [] x;
    double [] y;
    double a=2.8;
    double b=-0.3;
    double c=4;
    double x1=0;
    double x2=2;
    double dx=0.002;

    public  double calculateY(double x)
    {

        if (Math.abs(x-1.4)<0.0001)
        {
            return  (a/x)+Math.sqrt(x*x+1);
        }
        else if (x<1.4)
        {
            return a*(x*x)+b*x+c;
        }
        else
        {
            return  (a+b*x)/Math.sqrt(x*x+1);
        }
    }

    public  int countOfSteps(double x1, double x2, double deltaX)
    {
        double result=(x2-x1)/deltaX+1;
        return (int) result;
    }

    public void fillY(double[] x)
    {
        y=new double[x.length];

        for (int i=0;i<x.length;i++)
        {
            y[i]=calculateY(x[i]);
        }
    }

    public void fillX(double fX, double lX, double dX)
    {
        int size = countOfSteps(fX,lX,dX);
        x=new double[size];
        for(int i=0;i<x.length;i++)
        {
            x[i]=fX+dX*i;
        }
    }



    public int findMax(double [] array) {
        double max = array[0];
        int index=0;
        for(int i=0; i<array.length; i++ ) {
            if(array[i]>max) {
                max = array[i];
                index=i;
            }
        }
        return index;
    }
    public int findMin(double [] array) {
        double min = array[0];
        int index=0;
        for(int i=0; i<array.length; i++ ) {
            if(array[i]<min) {
                min = array[i];
                index=i;
            }
        }
        return index;
    }

    public double summArray(double[] array)
    {
        double result=0;

        for (double v : array) {
            result += v;
        }
        return  result;
    }

    public double midSummArray(double[] array)
    {
        summArray(array);
        return  summArray(array)/array.length;
    }
    public void showMinMax()
    {
        fillX(x1,x2,dx);
        fillY(x);
        System.out.printf("Max value = %f; Index = %d\n",y[findMax(y)],findMax(y));
        System.out.printf("Min value = %f; Index = %d",y[findMin(y)],findMin(y));

    }

}
