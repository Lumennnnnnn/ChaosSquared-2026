package org.firstinspires.ftc.teamcode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class PetersHelloWorld extends OpMode {

         @Override
         public void init() {
         // this sends to the driver station
            telemetry.addData("Hello","World");
             }

         @Override
 public void loop() {
         // intentionally left blank
         }
 }