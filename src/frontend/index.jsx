import React from 'react'
import './index.css'
import cloud from './assets/cloud.jpeg'
import './index.js'
const Index = () => {
  return (
    <div className="container">
      <div >
           <form className="sub-container" id="myForm" action=''>
                <div className='box'>
                    <div className="header">
                    </div>
                    <hr/>
                        <h1>Assignment Task</h1>
                        <hr />
                        <div className="email">
                            <div className="left">
                                <p style={{color:"black"}}>Email</p>&nbsp;
                                <a href=''>Switch Account</a>
                            </div>
                            <div className="right">
                                <img src={cloud} alt='cloud' width="20px" height="20px" /> &nbsp; Draft Saved
                            </div>
                       <br/> <br />
                        </div>
                       <p style={{fontSize:"15px"}}>The name and photo associated with your Google account will be recorded when you upload files and submit this form. Your email is not part of your response.</p><br />
                      <hr />

                      <p style={{fontSize:"15px",color:"red",textAlign:"left", paddingTop:"15px"}} className='indicate'>* Indicates required question</p>
                        
                    
                </div>
                <div className='box-1' >
                    <div className="mcq">
                    <label for="mcq" required>MCQ<span>*</span></label><br/>
                    <div className="radio">
                        <br />
                    <label>
                    <input type="radio" value={"Option 1"}/>&nbsp;
                    Option 1</label><br/>
                    <label>
                    <input type="radio" value={"Option 2"} />&nbsp;
                    Option 2</label>
                    <label><br/>
                    <input type="radio" value={"Option 3"} />
                   &nbsp; Option 3</label>
                    </div>
                    </div>
                </div>
                <div className='box-1'>
                <label for="Checkbox" required>Checkbox<span>*</span></label>
                <div className="check"><br />
                <label>
                    <input type="checkbox" value={"Option 1"}/>&nbsp;
                    Option 1
                </label><br />
                <label>
                    <input type="checkbox" value={"Option 2"}/>&nbsp;
                    Option 2
                </label><br />
                <label>
                    <input type="checkbox" value={"Option 3"}/>&nbsp;
                    Option 3
                </label>
                </div>

                </div>
                <div className='box-2'>
                    <label for="short" required>Short Answer<span>*</span></label><br /><br />
                    <input type='text' placeholder='Your Answer' className='text'/>
                </div>
                <div className='box-2'>
                    <label for="para" required>ParaGraph<span>*</span></label><br /><br />
                    <input type='text' placeholder='Your Answer' className='textpara'/>
                </div>
                <div className="box-3">
                    <label for="drop" required>Drop down<span>*</span></label><br /><br />
                    <select placeholder='Choose'>
                        <option>Option 1 </option>
                        <option>Option 2 </option>
                        <option>Option 3 </option>
                    </select>
                </div>
                <div className="box-2">
                    <label>File Upload <span>*</span></label><br/><br />
                    <input type='file' required placeholder='Add File'/>

                </div>
                <div className='box-4'>
                <label for="linear" required>Linear Scale<span>*</span> </label><br /><br/>
                  <div className="num">
                  <label for="rating2">1</label>
                  <label for="rating2">2</label>
                  <label for="rating2">3</label>
                  <label for="rating2">4</label>
                  <label for="rating2">5</label>
                  </div> <br />
                  <div className="best">
                <label for="worst">Worst</label>
                <input type="radio" id="rating2" name="rating" value="1"/>
                 <input type="radio" id="rating2" name="rating" value="2"/>
                 <input type="radio" id="rating2" name="rating" value="3"/>
                 <input type="radio" id="rating2" name="rating" value="4"/>
                 <input type="radio" id="rating2" name="rating" value="5"/>
                 <label for="best">Best</label>
                 </div>
                </div>

                <div className="multi-choice">
                     <label for="multi">Multi choice Grid<span>*</span></label><br /><br />
                       <div className="column">
                           <label for="col1">Column 1</label>
                           <label for="col2">Column 2</label>
                           <label for="col3">Column 3</label>   
                       </div>
                       <div className="row"><br />
                       <div className="row-set">
                       <label for="row1">Row 1 </label>
                       <input type="radio"/>
                       <input type="radio"/>
                       <input type="radio"/></div><br />
                       <div className="row-set">
                       <label for="row2">Row 2</label>
                       <input type="radio"/>
                       <input type="radio"/>
                       <input type="radio"/></div><br />
                       <div className="row-set">
                       <label for="row3">Row 3</label>
                       
                       <input type="radio"/>
                       <input type="radio"/>
                       <input type="radio"/></div>
                       
                       </div>
  
                </div>
                <div className="tick">
                     <label for="tick">Tick box Grid<span>*</span></label><br /><br />
                       <div className="column">
                           <label for="col1">Column 1</label>
                           <label for="col2">Column 2</label>
                           <label for="col3">Column 3</label>   
                       </div>
                       <div className="row"><br />
                       <div className="row-set">
                       <label for="row1">Row 1</label>
                       <input type="checkbox"/>
                       <input type="checkbox"/>
                       <input type="checkbox"/>
                       </div><br />
                       <div className="row-set">
                       <label for="row2">Row 2</label>
                       <input type="checkbox"/>
                       <input type="checkbox"/>
                       <input type="checkbox"/></div><br />
                       <div className="row-set">
                       <label for="row3">Row 3</label>
                       <input type="checkbox"/>
                       <input type="checkbox"/>
                       <input type="checkbox"/></div>
                       
                       </div>
                    
                </div>
                <br />
                <div className="last">
                <button type='submit' className='submit' onClick={"submitButton"}>Submit</button>
                <label>
                <input type='range'id="pageRange" name="pageRange" min="1" max="1" value="1" oninput="updatePageNumber()"/>Page <span id="pageNumber">1</span>  of 1</label>
                <a href='' onClick={"clearForm"}>Clear form</a>
          </div>
            </form>
            <div className='content'>
                <p className='never'>Never submit passwords through Google Forms.</p><br />
            <div >
                <p>This content is neither created nor endorsed by Google. Report Abuse - Terms of Service - Privacy Policy</p>
            </div></div>
            <br />
            <div className="footer">
                    <a href='https://www.google.com/forms/about/?utm_source=product&utm_medium=forms_logo&utm_campaign=forms'><span>Google </span>Forms</a>  
            </div>
        </div>
      </div>
  )
}

export default Index
