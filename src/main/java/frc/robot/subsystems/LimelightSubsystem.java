// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase {
  /** Creates a new LimelightSubsystem. */
  NetworkTable table;

  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;

  double x;
  double y;
  double area;
  
  public LimelightSubsystem() {
    table = NetworkTableInstance.getDefault().getTable("limelight-cavbots");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");

    //read values periodically
    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0);
  }

  public void updateValues() {
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");

    //read values periodically
    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0);
    // SmartDashboard.putNumber("X v",x);
    // SmartDashboard.putNumber("Y v", y);
    // SmartDashboard.putNumber("Area values", area);
  }

  public double getX()
  {
    return x;
  }

  public double getY()
  {
    return y;
  }

  public double getArea()
  {
    return area;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updateValues();
  }

  public double getDistance()
  {
    return (2.74-.56) / Math.tan(10+getY());
  }

  public double getRPM()
  {
    if(getDistance()>2&&getDistance()<6)
    {
      return 4500;
    }
    return 3000;
  }
}
