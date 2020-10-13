package by.it.fedorinhyk.calc;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    Vector (double[]value){
        this.value=value;
    }

    Vector (Vector vector){
        double[] tmp = vector.value;
        this.value = Arrays.copyOf(tmp,tmp.length);
    }
    Vector (String strVector) {
        String[] str = strVector.replace('{',' ').replace('}',' ')
                .trim().split(",");
        value=new double[str.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(str[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += otherScalar.getValue();
            }
            return new Vector(sum);
        }
        else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += otherVector.value[i];
            }
            return new Vector(sum);
        }
        else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= otherScalar.getValue();
            }
            return new Vector(sub);
        }
        else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= otherVector.value[i];
            }
            return new Vector(sub);
        }
        else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] *=((Scalar)other).getValue();
            }
            return new Vector(mul);
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] mult = Arrays.copyOf(value, value.length);
            double mul=0;
            for (int i = 0; i < mult.length; i++) {
                mul+= mult[i] * otherVector.value[i];
            }
            return new Scalar(mul);
        }
        else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] div = Arrays.copyOf(value, value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] /= otherScalar.getValue();
            }
            return new Vector(div);
        }
        else return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sbv=new StringBuilder("{");
        String delimiter="";
        for (double element : value){
            sbv.append(delimiter).append(element);
            delimiter=", ";
        }
        sbv.append("}");
        return sbv.toString();
    }
}
