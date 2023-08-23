import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Index from './frontend/index'

const AllRoutes = () => {
  return (
    <div>
      <Routes>
        <Route path='/index' element={<Index />} />
      </Routes>
    </div>
  )
}

export default AllRoutes
