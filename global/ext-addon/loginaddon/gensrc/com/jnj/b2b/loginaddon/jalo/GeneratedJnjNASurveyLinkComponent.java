/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Apr 26, 2015 2:49:18 PM                     ---
 * ----------------------------------------------------------------
 */
package com.jnj.b2b.loginaddon.jalo;

import com.jnj.b2b.loginaddon.constants.LoginaddonConstants;
import de.hybris.platform.cms2.jalo.contents.components.CMSLinkComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cms2.jalo.contents.components.CMSLinkComponent JnjNASurveyLinkComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedJnjNASurveyLinkComponent extends CMSLinkComponent
{
	/** Qualifier of the <code>JnjNASurveyLinkComponent.surveyEnabled</code> attribute **/
	public static final String SURVEYENABLED = "surveyEnabled";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CMSLinkComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(SURVEYENABLED, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjNASurveyLinkComponent.surveyEnabled</code> attribute.
	 * @return the surveyEnabled - This holds true if globally, survey is enabled. Else it holds false.
	 */
	public Boolean isSurveyEnabled(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, SURVEYENABLED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjNASurveyLinkComponent.surveyEnabled</code> attribute.
	 * @return the surveyEnabled - This holds true if globally, survey is enabled. Else it holds false.
	 */
	public Boolean isSurveyEnabled()
	{
		return isSurveyEnabled( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjNASurveyLinkComponent.surveyEnabled</code> attribute. 
	 * @return the surveyEnabled - This holds true if globally, survey is enabled. Else it holds false.
	 */
	public boolean isSurveyEnabledAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isSurveyEnabled( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>JnjNASurveyLinkComponent.surveyEnabled</code> attribute. 
	 * @return the surveyEnabled - This holds true if globally, survey is enabled. Else it holds false.
	 */
	public boolean isSurveyEnabledAsPrimitive()
	{
		return isSurveyEnabledAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjNASurveyLinkComponent.surveyEnabled</code> attribute. 
	 * @param value the surveyEnabled - This holds true if globally, survey is enabled. Else it holds false.
	 */
	public void setSurveyEnabled(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, SURVEYENABLED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjNASurveyLinkComponent.surveyEnabled</code> attribute. 
	 * @param value the surveyEnabled - This holds true if globally, survey is enabled. Else it holds false.
	 */
	public void setSurveyEnabled(final Boolean value)
	{
		setSurveyEnabled( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjNASurveyLinkComponent.surveyEnabled</code> attribute. 
	 * @param value the surveyEnabled - This holds true if globally, survey is enabled. Else it holds false.
	 */
	public void setSurveyEnabled(final SessionContext ctx, final boolean value)
	{
		setSurveyEnabled( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>JnjNASurveyLinkComponent.surveyEnabled</code> attribute. 
	 * @param value the surveyEnabled - This holds true if globally, survey is enabled. Else it holds false.
	 */
	public void setSurveyEnabled(final boolean value)
	{
		setSurveyEnabled( getSession().getSessionContext(), value );
	}
	
}
