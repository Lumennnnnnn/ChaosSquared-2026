package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotLocation {
    double angle;
    double x;
    double y;

    public RobotLocation(double angle){
        this.angle = angle;
    }

    public double getHeading(){
        double angle = this.angle;
        while(angle > 180){
            angle -= 360;
        }
        return angle;
    }

    public double getX(){
        return this.x;
    }

    public void changeX(double change){
        x += change;
    }

    public void setX(double x){
        this.x = x;
    }

    public void changeY(double change){
        y += change;
    }

    public void setY(double y){
        this.y = y;
    }
    public double getY(){
        return this.y;
    }

    @Override
    public String toString(){
        return "RobotLocation: angle (" + angle + ")";
    }

    public void turn(double angleChange){
        angle += angleChange;
    }
    public void setAngle(double angle){
        this.angle = angle;
    }
}
