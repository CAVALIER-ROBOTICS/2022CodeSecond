// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HoodSubsystem extends SubsystemBase {
  /** Creates a new HoodSubsystem. */
  CANSparkMax hoodMotor = new CANSparkMax(Constants.hoodID,MotorType.kBrushless);
  RelativeEncoder hoodEnc = hoodMotor.getEncoder();
  double eff = 1.0;
  
  public HoodSubsystem() {
    hoodMotor.setInverted(true);
    hoodEnc.setPosition(0);
  }

  public void setHood(double x)
  {
    hoodMotor.set(x);
  }

  public double getPos()
  {
    return hoodEnc.getPosition();
  }

  public double getSetpoint(double rpm, double distance) //convert rpm to meters per second
  {
    double x = Math.acos((9.8*distance)/(rpm*eff*(4*Math.PI)/2362.2));
    return x;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Hood Enc", hoodEnc.getPosition());
  }
}
