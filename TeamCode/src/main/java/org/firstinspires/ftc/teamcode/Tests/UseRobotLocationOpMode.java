package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class UseRobotLocationOpMode extends OpMode {
    RobotLocation robotLocation = new RobotLocation();
    String isTouchPressed = "";
    String motorState = "";
    double leftX = 0.0;

    @Override
    public void init(){
        robotLocation.init(hardwareMap);
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            motorState = "Brake";
            robotLocation.setZeroPowerBehavor(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if(gamepad1.b){
            motorState = "Float";
            robotLocation.setZeroPowerBehavor(DcMotor.ZeroPowerBehavior.FLOAT);
        }
        robotLocation.setMotorSpeed(robotLocation.squareInputWithSign(gamepad1.left_stick_x));
//        if(robotLocation.touchSensor.isPressed()){
//            isTouchPressed = "Pressed";
//        } else {
//            isTouchPressed = "Not Pressed";
//        }
        telemetry.addData("Motor State", motorState);
//        telemetry.addData("Touch Sensor State", isTouchPressed);
        telemetry.update();
    }
}
