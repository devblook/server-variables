package svar.ajneb97.api;

import org.bukkit.entity.Player;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import svar.ajneb97.ServerVariables;

public class ServerVariablesExpansion extends PlaceholderExpansion {

    // We get an instance of the plugin later.
    private ServerVariables plugin;

    public ServerVariablesExpansion(ServerVariables plugin) {
    	this.plugin = plugin;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public String getAuthor(){
        return "Ajneb97";
    }

    @Override
    public String getIdentifier(){
        return "servervariables";
    }

    @Override
    public String getVersion(){
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier){

        if(identifier.startsWith("globalvalue_")){
        	// %servervariables_globalvalue_<variable>%
        	String variableName = identifier.replace("globalvalue_", "");
            return ServerVariablesAPI.getServerVariableValue(variableName);
        }else if(identifier.startsWith("value_")){
            // %servervariables_value_<variable>%
            if(player == null){
                return "";
            }
            String variableName = identifier.replace("value_", "");
            return ServerVariablesAPI.getPlayerVariableValue(player.getName(),variableName);
        }

        return null;
    }
}
