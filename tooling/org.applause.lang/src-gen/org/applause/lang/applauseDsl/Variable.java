/**
 */
package org.applause.lang.applauseDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.applause.lang.applauseDsl.Variable#getParameterReference <em>Parameter Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.applause.lang.applauseDsl.ApplauseDslPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends UrlFragment
{
  /**
   * Returns the value of the '<em><b>Parameter Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter Reference</em>' containment reference.
   * @see #setParameterReference(ParameterReference)
   * @see org.applause.lang.applauseDsl.ApplauseDslPackage#getVariable_ParameterReference()
   * @model containment="true"
   * @generated
   */
  ParameterReference getParameterReference();

  /**
   * Sets the value of the '{@link org.applause.lang.applauseDsl.Variable#getParameterReference <em>Parameter Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter Reference</em>' containment reference.
   * @see #getParameterReference()
   * @generated
   */
  void setParameterReference(ParameterReference value);

} // Variable
