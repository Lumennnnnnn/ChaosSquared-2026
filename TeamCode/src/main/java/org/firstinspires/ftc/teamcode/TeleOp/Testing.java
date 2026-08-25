package org.firstinspires.ftc.teamcode.TeleOp;

import android.annotation.SuppressLint;

import com.bylazar.configurables.annotations.IgnoreConfigurable;
import com.bylazar.telemetry.TelemetryManager;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Libs.ConstantChaos;
import org.firstinspires.ftc.teamcode.Libs.Robot3;

@TeleOp(name = "Testing", group = "TeleOp")
public class Testing extends OpMode {

    @IgnoreConfigurable
    static TelemetryManager telemetryM;

    Robot3 robot = new Robot3(ConstantChaos.isRed);

    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("heading", robot.getLastPose().getHeading());
        telemetry.update();
    }

    @Override
    public void start() {}

    @SuppressLint("DefaultLocale")
    @Override
    public void loop() {
        //Driving----------------
        double y = gamepad1.left_stick_y/2;   // Forward/back
        double x = -gamepad1.left_stick_x/2;    // Strafe
        double rx = -gamepad1.right_stick_x/2;  // Turn

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1); //Math

        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        // Set motor powers
        robot.setDesiredFrontLeft(frontLeftPower);
        robot.setDesiredFrontRight(frontRightPower);
        robot.setDesiredBackLeft(backLeftPower);
        robot.setDesiredBackRight(backRightPower);
        robot.actMotors();
        //Driving----------------

        //Gamepad 2 stuff-currently on gamepad 1
        if(gamepad1.right_bumper){//intake
            robot.intake(-0.5);
        }else{
            robot.intake(0.0);
        }

        telemetry.addData("Gamepad 1 right stick", gamepad1.right_stick_x);
        telemetry.addData("Gamepad 1 b", gamepad1.b);
        telemetry.addData("difference of left and right sticks on gamepad 1", (gamepad1.left_stick_y-gamepad1.right_stick_y));
        telemetry.addData("sum of right and left triggers on gamepad 1", gamepad1.right_trigger+gamepad1.left_trigger);
        telemetry.update();

    }
    @Override
    public void stop() {
        telemetry.addLine("Stopped");
        telemetry.update();
    }
}