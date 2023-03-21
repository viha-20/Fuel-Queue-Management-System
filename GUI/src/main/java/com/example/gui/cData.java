//I declare that my work contains no examples of misconduct, such as
//plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//7/8/2022
package com.example.gui;

public class cData {
    String pump;
    int pos;
    String f;
    String s;
    String v;
    int rf;

    public cData(String pump, int pos, String f, String s, String v, int rf) {
        this.pump = pump;
        this.pos = pos;
        this.f = f;
        this.s = s;
        this.v = v;
        this.rf = rf;
    }

    public String getPump() {
        return pump;
    }

    public void setPump(String pump) {
        this.pump = pump;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public int getRf() {
        return rf;
    }

    public void setRf(int rf) {
        this.rf = rf;
    }
}
