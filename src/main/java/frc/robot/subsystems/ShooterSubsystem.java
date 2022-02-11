// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new KickerSubsystem. */
  CANSparkMax kickerMotor = new CANSparkMax(Constants.kickerID,MotorType.kBrushless);
  CANSparkMax rightShooter = new CANSparkMax(Constants.rightShooterID,MotorType.kBrushless);
  CANSparkMax leftShooter = new CANSparkMax(Constants.leftShootID,MotorType.kBrushless);

  CANSparkMax hoodMotor = new CANSparkMax(Constants.hoodID,MotorType.kBrushless);
  RelativeEncoder hoodEnc = hoodMotor.getEncoder();

  public ShooterSubsystem() 
  {
    leftShooter.setInverted(true);
    leftShooter.follow(rightShooter);
    leftShooter.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 60000);
    leftShooter.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 60000);
    kickerMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 60000);
    kickerMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 60000);
    // rightShooter.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 60000);
    // rightShooter.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 60000);


  }

  public void setKicker(double x)
  {
    kickerMotor.set(x);
  }

  public void setShooter(double x)
  {
    rightShooter.set(x);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Hood Enc", hoodEnc.getPosition());
  }
}
