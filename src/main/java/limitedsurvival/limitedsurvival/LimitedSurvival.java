package limitedsurvival.limitedsurvival;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class LimitedSurvival extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("limitedsurvival").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if(args.length == 0){
            p.sendMessage("§c불완전한 명령어입니다.");
        }

        return false;
    }

    @EventHandler
    public void Run(PlayerToggleSprintEvent a){
        Player p = a.getPlayer();
        p.sendMessage("달리지 마세요!");
        p.damage(1000);
    }
}
