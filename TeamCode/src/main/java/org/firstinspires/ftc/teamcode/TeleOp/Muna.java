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

    }
}

