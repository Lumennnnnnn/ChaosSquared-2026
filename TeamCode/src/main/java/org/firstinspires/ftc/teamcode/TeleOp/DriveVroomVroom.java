package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.teamcode.Libs.ConstantChaos.flyVel;
import static org.firstinspires.ftc.teamcode.Libs.ConstantChaos.resetPose;

import android.annotation.SuppressLint;

import com.bylazar.configurables.annotations.IgnoreConfigurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.PoseHistory;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Libs.ConstantChaos;
import org.firstinspires.ftc.teamcode.Libs.Robot3;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.List;

@TeleOp(name = "DriveVroomVroom", group = "TeleOp")
public class DriveVroomVroom extends OpMode {

    private Follower follower;

    @IgnoreConfigurable
    static PoseHistory poseHistory;

    @IgnoreConfigurable
    static TelemetryManager telemetryM;

    Robot3 robot = new Robot3(ConstantChaos.isRed);

    public double desiredFlywheelVelocity = 0.0;

    private PathChain goToShoot;
    private PathChain turnToShoot;
    private PathChain Park;

    public Pose Starting = new Pose(72, 8, Math.toRadians(0));

    @Override
    public void init() {
        robot.init(hardwareMap);
        follower = Constants.createFollower(hardwareMap);//new follower creator
        follower.setMaxPower(1.0);
        telemetry.addData("heading", robot.getLastPose().getHeading());
        follower.setStartingPose(Starting);
        telemetry.addData("Current Pose", follower.getPose());
        telemetry.update();
    }

    @Override
    public void start() {
        follower.startTeleopDrive();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void loop() {
        follower.update(); //MUST COME BEFORE SET TELE OP DRIVE
        //Okay, if something is reversed in the driving, try swapping the polarity here
        if (ConstantChaos.isRed) {
            follower.setTeleOpDrive(-gamepad1.left_stick_y/2, -gamepad1.left_stick_x/2, -gamepad1.right_stick_x/2, false);
        } else {
            follower.setTeleOpDrive(gamepad1.left_stick_y/2, gamepad1.left_stick_x/2, -gamepad1.right_stick_x/2, false);
        }
        follower.updateDrivetrain();
        //Driving------------------

        if (gamepad1.left_stick_button || gamepad1.right_stick_button) { //For when we code auto points in Teleop
            follower.startTeleopDrive();
        }

        if (gamepad1.left_trigger > 0.01){ //Quarter speed
            if (ConstantChaos.isRed) {
                follower.setTeleOpDrive(-gamepad1.left_stick_y/4, -gamepad1.left_stick_x/4, -gamepad1.right_stick_x/4, false);
            } else {
                follower.setTeleOpDrive(gamepad1.left_stick_y/4, gamepad1.left_stick_x/4, -gamepad1.right_stick_x/4, false);
            }
            follower.update();
        }

        if (gamepad1.right_trigger > 0.01){ //Full speed
            if (ConstantChaos.isRed) {
                follower.setTeleOpDrive(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x, false);
            } else {
                follower.setTeleOpDrive(gamepad1.left_stick_y, gamepad1.left_stick_x, -gamepad1.right_stick_x, false);
            }
            follower.update();
        }
        //Driving----------------

        //Auto points

        //Reset point
        if (gamepad1.backWasReleased()){
            follower.setPose(resetPose);
        }

        //Gamepad 2 stuff-currently on gamepad 1
        if(gamepad1.left_bumper) { //intake-check to see which one is intake vs outtake
            robot.intake(1.0);
        }else if(gamepad1.right_bumper){
            robot.intake(-1.0);
        }else{
            robot.intake(0.0);
        }

        telemetry.addData("Gamepad 1 right stick", gamepad1.right_stick_x);
        telemetry.addData("Gamepad 1 b", gamepad1.b);
        telemetry.addData("difference of left and right sticks on gamepad 1", (gamepad1.left_stick_y-gamepad1.right_stick_y));
        telemetry.addData("sum of right and left triggers on gamepad 1", gamepad1.right_trigger+gamepad1.left_trigger);
        telemetry.update();

        robot.draw(follower);

    }
    @Override
    public void stop() {
        telemetry.addLine("Stopped");
        telemetry.update();
    }
}