import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route,
  Routes
} from "react-router-dom";

import App from './App.jsx'
import './index.css'
import ErrorPage from './pages/ErrorPage.jsx';
import IndexPage from './pages/IndexPage.jsx';
import MainLayout from './layouts/MainLayout.jsx';
import TagsPage from './pages/TagsPage.jsx';
import CategoriesPage from './pages/CategoriesPage.jsx';
import ProfileComponent from './components/NavBarComponents/ProfileComponent.jsx';
import PostPage from './pages/PostPage.jsx';
import LoginPage from './pages/LoginPage.jsx';
import ForgotPasswordPage from './pages/ForgotPasswordPage.jsx';


const router = createBrowserRouter(
  createRoutesFromElements(
    <>
      {/* Root route */}
      <Route path="/" element={<LoginPage />} />
      <Route path="forgotpass" element={<ForgotPasswordPage />} />
     

      {/* Dashboard route with nested routes */}
      <Route path="/dashboard" errorElement={<ErrorPage />} element={<MainLayout />}>
        <Route path="home" element={<IndexPage />} /> {/* Default index route for /dashboard */}
        <Route path="categories" element={<CategoriesPage />} />
        <Route path="tags" element={<TagsPage />} />
        <Route path="Profile/:id" element={<ProfileComponent />} />
        <Route path="Post/:id" element={<PostPage />} />
      </Route>
    </>
  )
);

createRoot(document.getElementById('root')).render(
  <StrictMode>
       <RouterProvider router={router} />
  </StrictMode>,
)
