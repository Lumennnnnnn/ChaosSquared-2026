package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class UseRobotLocationOpMode extends OpMode {
    RobotLocation robotLocation = new RobotLocation(0);
    String isTouchPressed = "";

    @Override
    public void init(){
        robotLocation.setAngle(0);
        robotLocation.init(hardwareMap);
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            robotLocation.turn(0.1);
        } else if (gamepad1.b){
            robotLocation.turn(-0.1);
        }
        if(gamepad1.dpad_right){
            robotLocation.changeX(0.1);
        } else if (gamepad1.dpad_left){
            robotLocation.changeX(-0.1);
        } else if (gamepad1.dpad_up){
            robotLocation.changeY(0.1);
        } else if (gamepad1.dpad_down){
            robotLocation.changeY(-0.1);
        }
        if(robotLocation.touchSensor.isPressed()){
            isTouchPressed = "Pressed";
        } else {
            isTouchPressed = "Not Pressed";
        }
        telemetry.addData("Touch Sensor State", isTouchPressed);
        telemetry.addData("X", robotLocation.getX());
        telemetry.addData("Y", robotLocation.getY());
        telemetry.addData("Location", robotLocation);
        telemetry.addData("Heading", robotLocation.getHeading());
        telemetry.update();
    }
}
