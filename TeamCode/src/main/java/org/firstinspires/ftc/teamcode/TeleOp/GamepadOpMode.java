package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;import com.qualcomm.robotcore.eventloop.opmode.TeleOp;@TeleOp()
public class GamepadOpMode extends OpMode {
        @Override
        public void init() {
        }

        @Override
        public void loop() {
                telemetry.addData("Right stick x", gamepad1.right_stick_x);
                telemetry.addData("Right stick y", gamepad1.right_stick_y);
                telemetry.addData("Left stick x", gamepad1.left_stick_x);
                telemetry.addData("Left stick y", gamepad1.left_stick_y);
                double LeftStickY = gamepad1.left_stick_y;
                double RightStickY = gamepad1.left_stick_x;
                double difference = LeftStickY-RightStickY;
                double RightTrigger = gamepad1.right_trigger;
                double LeftTrigger = gamepad1.left_trigger;
                double addition = RightTrigger+ LeftTrigger;
                telemetry.addData("difference", difference);
                telemetry.addData("A button", gamepad1.a);
                telemetry.addData("B button", gamepad1.b);
                telemetry.addData("X button", gamepad1.x);
                telemetry.addData("Y button", gamepad1.y);
                telemetry.addData("Addition", addition);

        }
}