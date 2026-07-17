package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp( name = "MunaOpMode", group="TeleOp")
public class Muna extends OpMode {
String myName = "Muna";

    int teamNumber = 26630;
    double temperature = 99.9;
    boolean dad = true;
    @Override
    public void init() {
        telemetry.addData("team number",teamNumber);
        telemetry.addData( "temperature", temperature);
        telemetry.addData( "hi",dad );
        telemetry.addData("Hello", myName);
    }

    @Override
    public void loop() {
        telemetry.addData("right stick", gamepad1.right_stick_x);
        telemetry.addData("b",gamepad1.b);
        telemetry.addData("left - right stick", gamepad1.left_stick_y-gamepad1.right_stick_y);
        telemetry.addData("left + right trigger",gamepad1.left_trigger+gamepad1.right_trigger);
        telemetry.update();

    }
}

