package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Libs.ConstantChaos;
import org.firstinspires.ftc.teamcode.Libs.Robot3;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.List;

@TeleOp(name = "AprilTagDrive", group = "Teleop")
public class AprilTagDrive extends OpMode {
    private Follower follower;
    Robot3 robot = new Robot3(ConstantChaos.isRed);

    @Override
    public void init(){
        robot.init(hardwareMap);
        follower = Constants.createFollower(hardwareMap);//new follower creator
        follower.setMaxPower(1.0);
        follower.setStartingPose(robot.getLastPose());
    }

    @Override
    public void start() {
        follower.startTeleopDrive();
    }

    @Override
    public void loop() {
        List<AprilTagDetection> tags = robot.getAprilTags();
        for (AprilTagDetection detection : tags){
            telemetry.addData("Detections", detection.id);
            telemetry.update();
        }
        follower.update();
        for(AprilTagDetection detection : tags){
            if(detection.id == 21){
                follower.setTeleOpDrive(0.2, 0, 0);
            } else if (detection.id == 22){
                follower.setTeleOpDrive(0, 0.2, 0);
            } else if (detection.id == 23){
                follower.setTeleOpDrive(0,0, 0.2);
            }
        }
    }
}
