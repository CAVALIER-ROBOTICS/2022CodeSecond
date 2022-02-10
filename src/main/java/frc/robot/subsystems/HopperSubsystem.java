// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HopperSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  CANSparkMax hopperFloor = new CANSparkMax(Constants.floorID, MotorType.kBrushless);
  CANSparkMax hopperWall = new CANSparkMax(Constants.wallID, MotorType.kBrushless);
  
  public HopperSubsystem() {}

  public void setHopperFloor(double x){
    hopperFloor.set(x);
  }

  public void setHopperWall(double x){
    hopperWall.set(x);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
