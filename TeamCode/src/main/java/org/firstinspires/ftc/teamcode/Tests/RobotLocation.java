package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class RobotLocation {
    TouchSensor touchSensor;
    private DcMotor motor;

    public void init(HardwareMap hardwareMap) {
//        touchSensor = hardwareMap.get(TouchSensor.class, "touch_sensor");
        motor = hardwareMap.dcMotor.get("frontLeft");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setMotorSpeed(double x) {
        this.motor.setPower(x);
    }
    public double squareInputWithSign(double input){
        double output = input * input;
        if(output < 0){
            output = output * -1;
        }
        return output;
    }
    public void setZeroPowerBehavor(DcMotor.ZeroPowerBehavior zpb) {
        motor.setZeroPowerBehavior(zpb);
    }
}
