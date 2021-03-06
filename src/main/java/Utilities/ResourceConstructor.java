package Utilities;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import java.util.HashMap;

import static Utilities.ResourceConstructor.ResourceType.*;

public class ResourceConstructor {
    private ArmorStand base;
    private ItemStack gatheringTool;
    private String name;
    private ItemStack resourceMaterial;
    private Sound breakSound;
    private Particle breakParticle;
    private int durability;
    private HashMap<ItemStack, Integer> drop;

    public enum ResourceType {
        ORE,
        CROP,
        FISH,
        TREE
    }

    public ResourceConstructor(ArmorStand armorStand) {
        this.base = armorStand;
        this.base.setGravity(false);
        this.base.setVisible(false);
        this.base.setArms(false);
    }

    public ResourceConstructor setName(String name) {
        this.base.setCustomName(name);
        this.base.setCustomNameVisible(true);
        return this;
    }

    public ResourceConstructor setType(ResourceType type) {
        switch (type) {
            case ORE: {
                this.base.setArms(true);
                this.base.setLeftArmPose(new EulerAngle(125, 250, 10));
                this.base.setRightArmPose(new EulerAngle(225, 0, -75));
                this.base.setLeftLegPose(new EulerAngle(-145, 0, 0));
                this.base.setRightLegPose(new EulerAngle(225, 0, 0));
            }
            case CROP: {
                this.base.setArms(true);
                this.base.setLeftLegPose(new EulerAngle(-145, 0, 0));
                this.base.setRightLegPose(new EulerAngle(225, 0, 0));
                this.base.setLeftArmPose(new EulerAngle(200, 10, -135));
                this.base.setRightArmPose(new EulerAngle(135, 10, -135));
            }
            case FISH: {
                this.base.setArms(true);
                this.base.setLeftLegPose(new EulerAngle(-145, 0, 0));
                this.base.setRightLegPose(new EulerAngle(225, 0, 0));
            }
            case TREE: {

            }
        }
        return this;
    }

    public ResourceConstructor setMaterial(ItemStack itemStack) {
        this.base.getEquipment().setHelmet(itemStack);
        this.base.getEquipment().setItemInMainHand(itemStack);
        this.base.getEquipment().setItemInOffHand(itemStack);

        return this;
    }

    public ArmorStand build() {
        return this.base;
    }

}
