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
  CANSparkMax rightShooter = new CANSparkMax(Constants.rightShooterID,MotorType.kBrushless);
  CANSparkMax leftShooter = new CANSparkMax(Constants.leftShootID,MotorType.kBrushless);
  RelativeEncoder leftEnc = leftShooter.getEncoder();
  RelativeEncoder rightEnc = rightShooter.getEncoder();



  public ShooterSubsystem() 
  {
    leftShooter.setInverted(true);
    rightShooter.follow(leftShooter, false);
    // leftShooter.follow(rightShooter);


    // leftShooter.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 60000);
    // leftShooter.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 60000);
    
    rightShooter.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 50000);
    rightShooter.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 50500);
  }

  public void setShooter(double x)
  {
    // rightShooter.set(x);
    leftShooter.set(x);
    SmartDashboard.putNumber("fly wheel", leftEnc.getVelocity());
  }

  public double getVolicty()
  {
    return rightEnc.getVelocity();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler ru
    
  }
}
