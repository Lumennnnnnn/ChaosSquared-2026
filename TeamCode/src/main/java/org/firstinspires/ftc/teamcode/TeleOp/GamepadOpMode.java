package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp()
public class GamepadOpMode extends OpMode {
        @Override
        public void init() {
        }

        @Override
        public void loop() {

                double ForwardSpeed;
                double JoystickX;
                double JoystickY;
            if (!gamepad1.a) {
                ForwardSpeed = 0.5;
            }
            else {
                    ForwardSpeed = 1;
            }
                telemetry.addData("ForwardSpeed", ForwardSpeed);
            if (!gamepad1.x) {
                   JoystickX = gamepad1.left_stick_x;
                   JoystickY = gamepad1.left_stick_y;
                   telemetry.addData("Normal", "Mode");
            }
            else {
                    JoystickX = gamepad1.left_stick_y;
                    JoystickY = gamepad1.left_stick_x;
                    telemetry.addData("Crazy", "Mode");
            }
            telemetry.addData("JoystickX", JoystickX);
            telemetry.addData("JoystickY", JoystickY);


        }
}
